package br.com.locarena.api.domain.reserva.validacoes;

import br.com.locarena.api.domain.quadra.Quadra;
import br.com.locarena.api.domain.reserva.DadosReserva;
import br.com.locarena.api.domain.reserva.Reserva;
import br.com.locarena.api.domain.usuario.Usuario;

public interface ValidadorReservas {
    void validar(DadosReserva dadosReserva);
}
