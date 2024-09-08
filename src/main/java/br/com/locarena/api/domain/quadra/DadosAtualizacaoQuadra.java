package br.com.locarena.api.domain.quadra;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoQuadra(
        @NotNull
        Long id,
        @NotNull
        boolean churrasqueira,
        @NotNull
        float aluguel
) {
}
