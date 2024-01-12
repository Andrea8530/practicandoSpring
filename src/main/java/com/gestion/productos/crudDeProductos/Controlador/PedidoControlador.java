package com.gestion.productos.crudDeProductos.Controlador;

import com.gestion.productos.crudDeProductos.DTO.PedidoDto;
import com.gestion.productos.crudDeProductos.Modelo.Pedido;
import com.gestion.productos.crudDeProductos.Servicio.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoControlador {
    @Autowired
    private PedidoServicio servicio;

    @GetMapping
    public ResponseEntity<?> listarPedidos (){
        List<PedidoDto> pedidoDtos = servicio.listaDePedidos();
        return new ResponseEntity<>(pedidoDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> crearPedido(@RequestBody Pedido pedido){
       Pedido pedido1 = servicio.crearPedido(pedido);
       return ResponseEntity.status(HttpStatus.OK).body(pedido1);
    }


}
