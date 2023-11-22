package br.com.fiap.domain.User;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public record LoginResponseDTO(
        String token,
        String email,
        Collection<? extends GrantedAuthority> roles,
        String firstName,
        String id
) {
}
