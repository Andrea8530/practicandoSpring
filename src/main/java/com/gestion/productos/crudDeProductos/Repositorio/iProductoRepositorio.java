package com.gestion.productos.crudDeProductos.Repositorio;

import com.gestion.productos.crudDeProductos.Modelo.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface iProductoRepositorio extends JpaRepository<Producto,Long> {
    Boolean existsByNombre(String nombre);
    Producto findByNombre(String nombre);
    @Modifying
    @Transactional
    @Query ("update Producto set stock = stock + :cantidad where idProducto = :id")
    void sumarStock (@Param("cantidad")int cantidad, @Param("id")Long id);

}
