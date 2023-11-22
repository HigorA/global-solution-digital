package br.com.fiap.controllers;

import br.com.fiap.domain.FamilyHistory.FamilyHistory;
import br.com.fiap.domain.FamilyHistory.RegisterFamilyHistoryDTO;
import br.com.fiap.domain.User.User;
import br.com.fiap.repositories.FamilyHistoryRepository;
import br.com.fiap.services.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/family")
@SecurityRequirement(name = "Bearer Authentication")
public class FamilyHistoryController {

    @Autowired
    private FamilyHistoryRepository familyHistoryRepository;
    @Autowired
    private UserService userService;

    public FamilyHistoryController(FamilyHistoryRepository familyHistoryRepository, UserService userService) {
        this.familyHistoryRepository = familyHistoryRepository;
        this.userService = userService;
    }

    @PostMapping("/{id}/save")
    public ResponseEntity<FamilyHistory> save(@RequestBody RegisterFamilyHistoryDTO data, @PathVariable String id) {
        FamilyHistory familyHistory = new FamilyHistory(data);
        User user = userService.findUserById(id);
        familyHistory.setUser(user);
        return ResponseEntity.status(201).body(familyHistoryRepository.save(familyHistory));
    }

    @GetMapping("/{id}/get")
    public ResponseEntity<Page<FamilyHistory>> get(@PageableDefault(size = 2, sort = {"id"}, direction = Sort.Direction.DESC) Pageable page, @PathVariable String id) {
        return ResponseEntity.ok(familyHistoryRepository.findByUserId(UUID.fromString(id), page));
    }
}
