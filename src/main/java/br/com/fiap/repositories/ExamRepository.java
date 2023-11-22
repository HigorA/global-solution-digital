package br.com.fiap.repositories;

import br.com.fiap.domain.Address.Address;
import br.com.fiap.domain.Exam.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ExamRepository extends JpaRepository<Exam, Long> {

    List<Exam> findAllByUserId(UUID id);
    Page<Exam> findByUserId(UUID id, Pageable page);
}
