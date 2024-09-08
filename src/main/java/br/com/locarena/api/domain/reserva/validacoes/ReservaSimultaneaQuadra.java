package br.com.locarena.api.domain.reserva.validacoes;

import br.com.locarena.api.domain.reserva.DadosReserva;
import br.com.locarena.api.domain.reserva.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservaSimultaneaQuadra implements ValidadorReservas{
    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public void validar(DadosReserva dadosReserva) {
        System.out.println("cheguei na reserva simultanea.");
        var reservaSimultanea = reservaRepository.existsByQuadraIdAndData(
                dadosReserva.quadraId(), dadosReserva.diaReserva(),
                dadosReserva.horaReserva(), dadosReserva.horaReserva().plusHours(dadosReserva.tempoReserva())
        );
        if (reservaSimultanea == 1){
            throw new RuntimeException("Quadra não pode ter reservas simultâneas");
        }
    }
}
