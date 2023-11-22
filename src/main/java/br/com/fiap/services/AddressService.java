package br.com.fiap.services;

import br.com.fiap.domain.Address.Address;
import br.com.fiap.domain.Address.RegisterAddressDTO;
import br.com.fiap.domain.User.User;
import br.com.fiap.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserService userService;

    @Cacheable("addresses")
    public Page<Address> findAll(String id, Pageable pageable) {
        Page<Address> exams = addressRepository.findByUserId(UUID.fromString(id), pageable);
        return exams;
    }

    public Address save(RegisterAddressDTO data, String id) {
        Address address = new Address(data);
        User user = userService.findUserById(id);
        address.setUser(user);
        return addressRepository.save(address);
    }
}
