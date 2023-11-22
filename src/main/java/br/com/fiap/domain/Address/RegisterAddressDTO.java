package br.com.fiap.domain.Address;

public record RegisterAddressDTO(
        String uf,
        String city,
        String neighborhood,
        String road,
        String number,
        String complement
) {
}
