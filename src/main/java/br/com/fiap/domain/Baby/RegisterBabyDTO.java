package br.com.fiap.domain.Baby;

public record RegisterBabyDTO(
        String name,
        Integer age,
        String gender
) {
}
