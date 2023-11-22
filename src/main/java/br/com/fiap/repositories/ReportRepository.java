package br.com.fiap.repositories;

import br.com.fiap.domain.Report.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findAllByUserId(UUID id);
    Page<Report> findByUserId(UUID id, Pageable page);
}
