package br.com.locarena.api.domain.reserva;

import br.com.locarena.api.domain.quadra.Quadra;
import br.com.locarena.api.domain.quadra.QuadraRepository;
import br.com.locarena.api.domain.reserva.validacoes.ValidadorReservas;
import br.com.locarena.api.domain.usuario.Usuario;
import br.com.locarena.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaReserva {

    @Autowired
    private List<ValidadorReservas> validadores;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private QuadraRepository quadraRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    public DadosDetalhamentoReserva reservar(DadosReserva dados) {
        Usuario usuario = usuarioRepository.getReferenceById(dados.usuarioId());
        Quadra quadra = quadraRepository.getReferenceById(dados.quadraId());


        //verificando a existencia do usuário
        if (!usuarioRepository.existsById(dados.usuarioId())){
            throw new RuntimeException("dados do usuário inválido.");
        }

        //verificando a existencia da quadra
        if (!quadraRepository.existsById(dados.quadraId())){
            throw new RuntimeException("dados da quadra inválido.");
        }

        //realizar as validações necessárias
        validadores.forEach(v -> v.validar(dados));

        var reserva = new Reserva(dados, usuario, quadra);

        reservaRepository.save(reserva);

        return null;
    }
}
