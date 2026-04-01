package org.example.MercaDAM;

/**
 * Enum con todos los productos disponibles y sus precios individuales.
 * @author David Giner
 */

public enum Producto {

    MANZANAS(2.30), PAN(1), ARROZ(3.50), POLLO(4.30), LECHE(1.30), ACEITE(8.30), HUEVOS(3.30), TOMATES(4), PASTA(0.89);

    private final double precio;

    Producto(double precio) {

        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
