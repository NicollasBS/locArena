package br.com.locarena.api.domain.reserva.validacoes;

import br.com.locarena.api.domain.reserva.DadosReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Component
public class ReservaAntecedenciaMinima implements ValidadorReservas{

    @Override
    public void validar(DadosReserva dadosReserva) {
        var horarioAtual = LocalTime.now();
        var diaAtual = LocalDate.now();

        var tempoFaltante = Math.toIntExact(ChronoUnit.HOURS.between(horarioAtual, dadosReserva.horaReserva()));
        var diaFaltante = Math.toIntExact(ChronoUnit.DAYS.between(diaAtual, dadosReserva.diaReserva()));

        if(diaFaltante <= 0){
            if (tempoFaltante < 2){
                throw new RuntimeException("Antecedencia mínima de duas horas antes da reserva");
            }
        }
    }
}
