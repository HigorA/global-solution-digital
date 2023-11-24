package br.com.fiap.domain.Exam;

public record RegisterExamDTO(
        Long id,
        String examName,
        String examType,
        String speciality
) {
}
