package com.gestion.productos.crudDeProductos.DTO;

import com.gestion.productos.crudDeProductos.Modelo.Detalle;
import com.gestion.productos.crudDeProductos.Modelo.Pedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class PedidoDto {
    private Long idPedido;
    private LocalDate fecha;
    private String nombreCliente;
    private List<Detalle> detalles;

    public PedidoDto(Long idPedido, LocalDate fecha, String nombreCliente, List<Detalle> detalles) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.detalles = detalles;
    }

    public PedidoDto(Pedido pedido) {
        this.idPedido = pedido.getIdPedido();
        this.fecha = pedido.getFecha();
        this.nombreCliente = pedido.getNombreCliente();
        this.detalles = pedido.getDetalles();
    }

    public PedidoDto() {
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }
}
