package com.gestion.productos.crudDeProductos.Exepciones;

import java.io.IOException;

public class ProductoNoEncontradoException extends IOException {
    public ProductoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
