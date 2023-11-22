package br.com.fiap.domain.Exam;

import br.com.fiap.domain.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String examName;
    private String examType;
    private LocalDateTime examDate;
    private String exameResult;
    private String examObservation;
    private String speciality;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    public Exam() {
    }

    public Exam(RegisterExamDTO data) {
        this.examName = data.examName();
        this.examType = data.examType();
        this.examDate = LocalDateTime.now();
        this.speciality = data.speciality();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public LocalDateTime getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDateTime examDate) {
        this.examDate = examDate;
    }

    public String getExameResult() {
        return exameResult;
    }

    public void setExameResult(String exameResult) {
        this.exameResult = exameResult;
    }

    public String getExamObservation() {
        return examObservation;
    }

    public void setExamObservation(String examObservation) {
        this.examObservation = examObservation;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", examName='" + examName + '\'' +
                ", examType='" + examType + '\'' +
                ", examDate=" + examDate +
                ", exameResult='" + exameResult + '\'' +
                ", examObservation='" + examObservation + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
