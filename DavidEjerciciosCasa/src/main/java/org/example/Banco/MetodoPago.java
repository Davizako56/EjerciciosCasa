package org.example.Banco;

/**
 * @author David Giner
 */
public abstract class MetodoPago {

    public MetodoPago() {

    }

    /**
     * Este metodo servira como base para las clases que hereden de MetodoPago y servira para procesar los pagos dependiendo de como paguemos
     * @param importe Sera la variable que se quede con la cantidad de dinero que queramoss pagar.
     */
    public void procesarPago(double importe) {
        System.out.println("Procesando pago de importe " + importe + "€");
    }
}
