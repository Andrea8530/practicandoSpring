package com.gestion.productos.crudDeProductos.Controlador;

import com.gestion.productos.crudDeProductos.DTO.ProductoDto;
import com.gestion.productos.crudDeProductos.Modelo.Producto;
import com.gestion.productos.crudDeProductos.Servicio.ProductoServicio;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoControlador {
    @Autowired
    private ProductoServicio servicio;

    @GetMapping
    public ResponseEntity<?> listaDeProductos() {
        List<ProductoDto> productos = servicio.listaDeProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody Producto produto){
        try {
            Producto nuevoProduto= servicio.crearProducto(produto);
            return new ResponseEntity<>(nuevoProduto, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarProducto(@PathVariable Long id){
        try{
            servicio.eliminarProducto(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarProducto(@PathVariable Long id, @RequestBody Producto producto){
        try{
            Producto productoEditado = servicio.editarProducto(id, producto);
            return ResponseEntity.status(HttpStatus.OK).body(productoEditado);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }


}
