package br.com.fiap.repositories;

import br.com.fiap.domain.Baby.Baby;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BabyRepository extends JpaRepository<Baby, Long> {

    List<Baby> findAllByUserId(UUID id);
}
