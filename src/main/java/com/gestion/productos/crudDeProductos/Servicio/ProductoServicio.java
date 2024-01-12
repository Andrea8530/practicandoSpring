package com.gestion.productos.crudDeProductos.Servicio;

import com.gestion.productos.crudDeProductos.DTO.ProductoDto;
import com.gestion.productos.crudDeProductos.Exepciones.ProductoNoEncontradoException;
import com.gestion.productos.crudDeProductos.Exepciones.ValorNegativoException;
import com.gestion.productos.crudDeProductos.Modelo.Producto;
import com.gestion.productos.crudDeProductos.Repositorio.iProductoRepositorio;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServicio {
    @Autowired
    private iProductoRepositorio repositorio;

    public List<ProductoDto> listaDeProductos (){
       // List<Producto> productos= repositorio.findAll();
        List<ProductoDto> productoDto = new ArrayList<>();
        for(Producto p : repositorio.findAll() ){
            productoDto.add(new ProductoDto(p));
        }
        return productoDto;
    }

    /*public Producto crearProducto (Producto producto) throws ValorNegativoException {
        if(repositorio.existsByNombre(producto.getNombre())){
            throw new IllegalArgumentException("Ya existe un producto con este nombre");
        }else if(producto.getPrecio()< 0 || producto.getStock()<0){
            throw new ValorNegativoException("No puede tener valores negativos");
        }
            return repositorio.save(producto);
    }*/

    public Producto crearProducto (Producto producto) throws ValorNegativoException {
        if(repositorio.existsByNombre(producto.getNombre())){
            Producto producto1 = repositorio.findByNombre(producto.getNombre());
            repositorio.sumarStock(producto.getStock(), producto1.getIdProducto());
            System.out.println("se actualizo la cantidad");
            return  repositorio.findById(producto1.getIdProducto()).orElse(null);
        }else if(producto.getPrecio()< 0 || producto.getStock()<0){
            throw new ValorNegativoException("No puede tener valores negativos");
        }
        return repositorio.save(producto);
    }

    public void eliminarProducto (Long id){
        if(!repositorio.existsById(id)){
            throw new EntityNotFoundException("El producto no existe");
        }
        repositorio.deleteById(id);
    }

    public Producto editarProducto(Long id, Producto producto) throws ProductoNoEncontradoException, ValorNegativoException {

        Producto productoExistente = repositorio.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException("El producto no existe"));

        if(producto.getPrecio()< 0 || producto.getStock()<0){
            throw new ValorNegativoException("No puede tener valores negativos");
        } else if (!productoExistente.getNombre().equals(producto.getNombre())) {
            if (repositorio.existsByNombre(producto.getNombre())) {
                throw new IllegalArgumentException("Ya existe un producto con este nombre");
            }
        }
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setStock(producto.getStock());
        return repositorio.save(productoExistente);
    }

}
