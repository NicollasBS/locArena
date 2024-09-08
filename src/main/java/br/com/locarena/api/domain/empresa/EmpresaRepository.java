package br.com.locarena.api.domain.empresa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Page<Empresa> findAllByAtivoTrue(Pageable paginacao);
}
