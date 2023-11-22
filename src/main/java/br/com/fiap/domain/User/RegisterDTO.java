package br.com.fiap.domain.User;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RegisterDTO(
        @NotNull
        @NotBlank
        @NotEmpty
        @Email
        String email,
        @NotNull
        @NotBlank
        @NotEmpty
        String password,
        String firstName,
        String lastName,
        String gender,
        @Schema(name = "birthdayDate", type = "string", format = "date", example = "2001-12-30")
        LocalDate birthdayDate,
        @NotNull
        UserRole role
) {
}
