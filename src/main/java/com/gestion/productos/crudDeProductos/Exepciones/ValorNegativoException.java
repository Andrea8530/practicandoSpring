package com.gestion.productos.crudDeProductos.Exepciones;

import java.io.IOException;

public class ValorNegativoException extends IOException {

    public ValorNegativoException() {
        super("El valor no puede ser negativo.");
    }

    public ValorNegativoException(String mensaje) {
        super(mensaje);
    }
}
