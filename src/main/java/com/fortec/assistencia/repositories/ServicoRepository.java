package com.fortec.assistencia.repositories;

import com.fortec.assistencia.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
