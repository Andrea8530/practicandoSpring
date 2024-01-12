package com.gestion.productos.crudDeProductos.Modelo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @Column(name = "nombreCliente", nullable = false, length = 50)
    private String nombreCliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) //esto permito que cuando borro un pedido borro los detalles que estan asociados
    private List<Detalle> detalles;

    public Pedido() {
    }

    public Pedido(Long idPedido, String nombreCliente, List<Detalle> detalles) {
        this.idPedido = idPedido;
        this.fecha = LocalDate.now();
        this.nombreCliente = nombreCliente;
        this.detalles = detalles;
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
