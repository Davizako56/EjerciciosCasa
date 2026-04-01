package org.example.MercaDAM;
import java.util.HashMap;

/**
 * Clase que contiene los métodos de Pedido y que define como esta se va a comportar
 * @author David Giner
 */

public class Pedido {

    private HashMap<Producto, Integer> pedido;
    private double importeTotal;

    public Pedido() {

        pedido  = new HashMap<>();
        importeTotal = 0;
    }

    public HashMap<Producto, Integer> getPedido() {
        return pedido;
    }

    public void setPedido(HashMap<Producto, Integer> pedido) {
        this.pedido = pedido;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {

        this.importeTotal = importeTotal;
    }

    /**
     * Método para actualizar el importe total conforme se van añadiendo productos al pedido.
     * @param importe Parámetro que indica el importe a sumarle al total del pedido.
     */
    public void actualizarImporteTotal(double importe) {

        importeTotal += importe;
    }

    public void aplicarPromo3x2() {

    }

    /**
     * Método que rebaja el importe total del pedido a un 10%.
     */
    public void aplicarPromo10() {

        importeTotal = importeTotal - (importeTotal * 0.1);
        setImporteTotal(importeTotal);
    }

    @Override

    public String toString() {

        return "[Pedido = " + pedido + ", importe total = " + importeTotal + "]";
    }
}