package br.com.fiap.controllers;

import br.com.fiap.domain.Exam.Exam;
import br.com.fiap.domain.Exam.RegisterExamDTO;
import br.com.fiap.services.ExamService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam")
@SecurityRequirement(name = "Bearer Authentication")
public class ExamController {

    @Autowired
    private ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/{id}/get")
    public ResponseEntity<Page<Exam>> getAll(@PageableDefault(size = 2, sort = {"examDate"}, direction = Sort.Direction.DESC) Pageable page, @PathVariable String id) {
        return ResponseEntity.status(200).body(examService.findAll(id, page));
    }

    @PostMapping("/{id}/save")
    public ResponseEntity<Exam> newExam(@RequestBody RegisterExamDTO data, @PathVariable String id) {
        Exam createdExam = examService.createExam(data, id);
        return ResponseEntity.status(201).body(createdExam);
    }
}
