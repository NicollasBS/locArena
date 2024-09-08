package br.com.locarena.api.domain.quadra;

public record DadosCadastroQuadra(
        Esporte esporte,
        boolean churrasqueira,
        float aluguel,
        Long idEmpresa
) {
}
