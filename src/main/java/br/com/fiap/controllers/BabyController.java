package br.com.fiap.controllers;

import br.com.fiap.domain.Baby.RegisterBabyDTO;
import br.com.fiap.services.BabyService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/baby")
@SecurityRequirement(name = "Bearer Authentication")
public class BabyController {

    @Autowired
    private BabyService babyService;

    public BabyController(BabyService babyService) {
        this.babyService = babyService;
    }

    @GetMapping("/{id}/get")
    public ResponseEntity getAll(@PathVariable String id) {
        return ResponseEntity.ok(babyService.findAll(id));
    }

    @PostMapping("/{id}/save")
    public ResponseEntity save(@RequestBody RegisterBabyDTO data, @PathVariable String id) {
        return ResponseEntity.status(201).body(babyService.createExam(data, id));
    }
}
