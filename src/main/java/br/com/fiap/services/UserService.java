package br.com.fiap.services;

import br.com.fiap.domain.User.User;
import br.com.fiap.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public User findUserById(String id) {
        return repository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Deu erro no findById"));
    }

}
