package br.com.locarena.api.domain.quadra;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuadraRepository extends JpaRepository<Quadra, Long> {
    Page<Quadra> findAllByAtivoTrue(Pageable paginacao);
}
