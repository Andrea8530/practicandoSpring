package com.gestion.productos.crudDeProductos.Repositorio;

import com.gestion.productos.crudDeProductos.Modelo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iPedidoRepositorio extends JpaRepository<Pedido,Long> {

}
