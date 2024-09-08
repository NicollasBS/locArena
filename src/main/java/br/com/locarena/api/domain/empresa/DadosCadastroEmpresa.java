package br.com.locarena.api.domain.empresa;

import br.com.locarena.api.domain.endereco.DadosEndereco;
import br.com.locarena.api.domain.endereco.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record DadosCadastroEmpresa(
        @NotBlank
        String nome,
        @NotNull
        DadosEndereco endereco,
        @NotBlank @Email
        String email,
        @NotBlank
        String telefone,
        @NotNull
        LocalTime horarioInicio,
        @NotNull
        LocalTime horarioTermino,
        @NotNull
        DayOfWeek diaInicio,
        @NotNull
        DayOfWeek diaTermino
) {
}
