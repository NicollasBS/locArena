package br.com.locarena.api.domain.empresa;

import br.com.locarena.api.domain.endereco.DadosEndereco;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record DadosDetalhadosEmpresa(
        Long id,
        String nome,
        DadosEndereco endereco,
        String email,
        String telefone,
        LocalTime horarioInicio,
        LocalTime horarioTermino,
        DayOfWeek diaInicio,
        DayOfWeek diaTermino
) {
    public DadosDetalhadosEmpresa(Empresa e){
        this(
                e.getId(),
                e.getNome(),
                new DadosEndereco(e.getEndereco()),
                e.getEmail(),
                e.getTelefone(),
                e.getHorarioInicio(),
                e.getHorarioTermino(),
                e.getDiaInicio(),
                e.getDiaTermino());
    }
}
