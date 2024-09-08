package br.com.locarena.api.domain.quadra;

import br.com.locarena.api.domain.empresa.Empresa;

public record DadosDetalhadosQuadra(
        Long id,
        Esporte esporte,
        boolean churrasqueira,
        Long empresa,
        String nomeEmpresa
) {
    public DadosDetalhadosQuadra(Quadra q){
        this(q.getId(), q.getEsporte(), q.isChurrasqueira(), q.getEmpresa().getId(), q.getEmpresa().getNome());
    }
}
