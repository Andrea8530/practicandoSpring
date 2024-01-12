package com.gestion.productos.crudDeProductos.DTO;

import com.gestion.productos.crudDeProductos.Modelo.Producto;

public class ProductoDto {
    private Long id;
    private String nombre;
    private Double precio;

    public ProductoDto() {
    }

    public ProductoDto(Long id, String nombre, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public ProductoDto(Producto producto){
        this.id = producto.getIdProducto();
        this.nombre = producto.getNombre();
        this.precio = producto.getPrecio();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
