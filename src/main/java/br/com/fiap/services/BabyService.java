package br.com.fiap.services;

import br.com.fiap.domain.Baby.Baby;
import br.com.fiap.domain.Baby.RegisterBabyDTO;
import br.com.fiap.domain.User.User;
import br.com.fiap.repositories.BabyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BabyService {

    @Autowired
    private BabyRepository babyRepository;
    @Autowired
    private UserService userService;


    public List<Baby> findAll(String id) {
        return babyRepository.findAllByUserId(UUID.fromString(id));
    }

    public Baby createExam(RegisterBabyDTO data, String id) {
        Baby baby = new Baby(data);
        User user = userService.findUserById(id);
        baby.setUser(user);
        return babyRepository.save(baby);
    }
}
