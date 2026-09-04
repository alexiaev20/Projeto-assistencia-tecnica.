package com.fortec.assistencia.repositories;

import com.fortec.assistencia.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
