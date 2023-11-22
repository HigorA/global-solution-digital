package br.com.fiap.domain.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AuthenticationDTO(
        @NotNull
        @NotBlank
        @NotEmpty
        @Email
        String email,
        @NotNull
        @NotBlank
        @NotEmpty
        String password
) {
}
