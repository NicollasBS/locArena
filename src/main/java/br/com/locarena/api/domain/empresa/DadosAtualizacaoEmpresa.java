package br.com.locarena.api.domain.empresa;

import br.com.locarena.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record DadosAtualizacaoEmpresa(
        @NotNull
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
}
