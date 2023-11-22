package br.com.fiap.repositories;

import br.com.fiap.domain.Address.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByUserId(UUID id);
    Page<Address> findByUserId(UUID id, Pageable page);
}
