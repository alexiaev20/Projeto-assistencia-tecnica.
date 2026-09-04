package com.fortec.assistencia.repositories;

import com.fortec.assistencia.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
