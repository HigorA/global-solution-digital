package br.com.fiap.controllers;

import br.com.fiap.domain.User.AuthenticationDTO;
import br.com.fiap.domain.User.LoginResponseDTO;
import br.com.fiap.domain.User.RegisterDTO;
import br.com.fiap.domain.User.User;
import br.com.fiap.exceptions.ExceptionDTO;
import br.com.fiap.infra.security.TokenService;
import br.com.fiap.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager, UserRepository repository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);
            var token = this.tokenService.generateToken((User) auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponseDTO(
                    token,
                    auth.getName(),
                    auth.getAuthorities(),
                    ((User) auth.getPrincipal()).getFirstName(),
                    ((User) auth.getPrincipal()).getId().toString())
            );
        } catch (Exception exception) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(HttpStatus.NOT_FOUND, "User not found."));
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data, encryptedPassword);

        this.repository.save(newUser);
        return ResponseEntity.ok().build();
    }

}
