package com.gestion.productos.crudDeProductos.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Detalle", uniqueConstraints = {@UniqueConstraint(columnNames = {"idPedido", "idProducto"})})
public class Detalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @ManyToOne
    @JoinColumn(name = "idPedido", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;
    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    public Detalle() {
    }

    public Detalle(Long idDetalle, Pedido pedido, Producto producto, int cantidad) {
        this.idDetalle = idDetalle;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
