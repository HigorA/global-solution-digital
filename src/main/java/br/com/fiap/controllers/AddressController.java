package br.com.fiap.controllers;

import br.com.fiap.domain.Address.RegisterAddressDTO;
import br.com.fiap.domain.Baby.RegisterBabyDTO;
import br.com.fiap.services.AddressService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@SecurityRequirement(name = "Bearer Authentication")
public class AddressController {

    @Autowired
    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}/get")
    public ResponseEntity getAll(@PageableDefault(size = 2, sort = {"uf"}, direction = Sort.Direction.DESC) Pageable page, @PathVariable String id) {
        return ResponseEntity.ok(addressService.findAll(id, page));
    }

    @PostMapping("/{id}/save")
    public ResponseEntity save(@RequestBody RegisterAddressDTO data, @PathVariable String id) {
        return ResponseEntity.status(201).body(addressService.save(data, id));
    }
}
