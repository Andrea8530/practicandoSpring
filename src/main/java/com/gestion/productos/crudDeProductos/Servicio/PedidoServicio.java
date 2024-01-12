package com.gestion.productos.crudDeProductos.Servicio;

import com.gestion.productos.crudDeProductos.DTO.PedidoDto;
import com.gestion.productos.crudDeProductos.Modelo.Pedido;
import com.gestion.productos.crudDeProductos.Repositorio.iPedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class PedidoServicio {
    @Autowired
    private iPedidoRepositorio repositorio;

    public List<PedidoDto> listaDePedidos (){
        List<PedidoDto> pedidos = new ArrayList<>();
        for(Pedido p : repositorio.findAll()){
            pedidos.add(new PedidoDto(p));
        }
        return pedidos;
    }

    public Pedido crearPedido (Pedido pedido){
        pedido.setFecha(LocalDate.now());
        pedido.setIdPedido(1L);

        return repositorio.save(pedido);
    }

}
