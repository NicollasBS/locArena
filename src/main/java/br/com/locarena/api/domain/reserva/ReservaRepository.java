package br.com.locarena.api.domain.reserva;

import br.com.locarena.api.domain.quadra.Quadra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    @Query(value = """
            SELECT EXISTS (
                SELECT 1
                FROM reservas
                WHERE quadra_id = :quadraId
                AND dia = :dia
                AND (
                    (:horarioInicio BETWEEN horario_inicio AND horario_termino)
                    OR (:horarioTermino BETWEEN horario_inicio AND horario_termino)
                    OR (horario_inicio BETWEEN :horarioInicio AND :horarioTermino)
                    OR (horario_termino BETWEEN :horarioInicio AND :horarioTermino)
                    )
            ) AS is_reserved
            """, nativeQuery = true)
    Long existsByQuadraIdAndData(@Param("quadraId") Long quadraId,
                                    @Param("dia") LocalDate dia,
                                    @Param("horarioInicio") LocalTime horarioInicio,
                                    @Param("horarioTermino") LocalTime horarioTermino);

    @Query(value = """
            SELECT EXISTS (
                SELECT 1
                FROM reservas
                WHERE usuario_id = :usuarioId
                AND dia = :dia
                AND (
                    (:horarioInicio BETWEEN horario_inicio AND horario_termino)
                    OR (:horarioTermino BETWEEN horario_inicio AND horario_termino)
                    OR (horario_inicio BETWEEN :horarioInicio AND :horarioTermino)
                    OR (horario_termino BETWEEN :horarioInicio AND :horarioTermino)
                    )
            ) AS is_reserved
            """, nativeQuery = true)
    Long existsByUsuarioIdAndDia(@Param("usuarioId") Long usuarioId,
                                 @Param("dia") LocalDate dia,
                                 @Param("horarioInicio") LocalTime horarioInicio,
                                 @Param("horarioTermino") LocalTime horarioTermino);
}
