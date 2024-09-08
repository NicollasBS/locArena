package br.com.locarena.api.domain.reserva;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosReserva(
        Long usuarioId,
        Long quadraId,
        LocalTime horaReserva,
        LocalDate diaReserva,
        int tempoReserva
) {
}
