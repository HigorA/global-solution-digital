package br.com.fiap.controllers;

import br.com.fiap.domain.Report.RegisterReportDTO;
import br.com.fiap.domain.Report.Report;
import br.com.fiap.services.ReportService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
@SecurityRequirement(name = "Bearer Authentication")
public class ReportController {

    @Autowired
    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/{id}/get")
    public ResponseEntity<Page<Report>> getAll(
            @PageableDefault(size = 2, sort = {"reportDate"}, direction = Sort.Direction.DESC) Pageable page,
            @PathVariable String id) {
        return ResponseEntity.ok(reportService.findAll(id, page));
    }

    @PostMapping("/{id}/save")
    public ResponseEntity<Report> saveRelatory(@PathVariable String id, @RequestBody RegisterReportDTO data) {
        Report createdReport = reportService.createRelatory(data, id);
        return ResponseEntity.status(201).body(createdReport);
    }
}
