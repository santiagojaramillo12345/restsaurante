package com.Main.Restaurant.Repositorio;

import com.Main.Restaurant.Entidades.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepositorio extends JpaRepository<Pedidos,Integer> {
}
