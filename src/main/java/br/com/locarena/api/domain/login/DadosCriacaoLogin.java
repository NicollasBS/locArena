package br.com.locarena.api.domain.login;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCriacaoLogin(
        @NotBlank
        String login,
        @NotBlank
        String senha,
        @NotNull
        Tipo tipo
) {
}
