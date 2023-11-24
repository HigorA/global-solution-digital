package br.com.fiap.services;

import br.com.fiap.domain.Exam.Exam;
import br.com.fiap.domain.Exam.RegisterExamDTO;
import br.com.fiap.domain.User.User;
import br.com.fiap.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private UserService userService;


    public Page<Exam> findAll(String id, Pageable pageable) {
        Page<Exam> exams = examRepository.findByUserId(UUID.fromString(id), pageable);
        return exams;
    }

    public Exam createExam(RegisterExamDTO data, String id) {
        Exam newExam = new Exam(data);
        User user = userService.findUserById(id);
        newExam.setUser(user);
        return examRepository.save(newExam);
    }

    public void deleteExam(Long id){
        examRepository.deleteById(id);
    }
}
