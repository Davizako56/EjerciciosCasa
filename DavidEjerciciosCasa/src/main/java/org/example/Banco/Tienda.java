package org.example.Banco;
import java.util.Scanner;

/**
 * @author David Giner
 */
public class Tienda {
    static Scanner entrada = new Scanner(System.in);

    /**
     * Este metodo sirve para introducir un importe y dependiendo del modo que hayamos elegido para pagar lammara a un metodo diferente.
     * @param metodo Esta variable sera la que se lleve que modo de pago hemos escogido.
     */
    public static void realizarPago(MetodoPago metodo) {

        System.out.println("Introduce el importe a pagar:");
        double importe = entrada.nextDouble();

        metodo.procesarPago(importe);
    }

    /**
     * Este metodo sirve simplemente para pedirnos que metodo de pago queremos escoger.
     */
    public static void iniciarPago() {

        System.out.println("Que método de pago quieres usar? [Bizum, PayPal, Tarjeta]");
        String opcion = entrada.next();

        if (opcion.equalsIgnoreCase("Bizum")) {

            Bizum bizum = new Bizum();
            realizarPago(bizum);
        }else if (opcion.equalsIgnoreCase("PayPal")) {

            System.out.println("Introduce el correo de la cuenta:");
            String cuenta = entrada.next();

            System.out.println("Introduce tu saldo:");
            double saldo = entrada.nextDouble();

            PayPal paypal = new PayPal(cuenta, saldo);
            realizarPago(paypal);
        }else if (opcion.equalsIgnoreCase("Tarjeta")) {

            TarjetaCredito tarjeta = new TarjetaCredito();
            realizarPago(tarjeta);
        }else{
            System.out.println("El método de pago no existe.");
        }
    }
}
