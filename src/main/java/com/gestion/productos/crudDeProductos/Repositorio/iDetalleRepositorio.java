package com.gestion.productos.crudDeProductos.Repositorio;

import com.gestion.productos.crudDeProductos.Modelo.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iDetalleRepositorio extends JpaRepository<Detalle,Long> {
}
