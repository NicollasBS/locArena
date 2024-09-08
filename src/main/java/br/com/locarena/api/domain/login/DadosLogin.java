package br.com.locarena.api.domain.login;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosLogin(
        String login,
        String senha
) {
}
