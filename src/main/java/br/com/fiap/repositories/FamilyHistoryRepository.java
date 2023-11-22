package br.com.fiap.repositories;

import br.com.fiap.domain.FamilyHistory.FamilyHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FamilyHistoryRepository extends JpaRepository<FamilyHistory, Long> {

    List<FamilyHistory> findAllByUserId(UUID id);
    Page<FamilyHistory> findByUserId(UUID id, Pageable page);
}
