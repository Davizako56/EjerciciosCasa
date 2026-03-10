package org.example.Banco;
import java.util.Scanner;

/**
 * @author David Giner
 */
public class TarjetaCredito extends MetodoPago{
    static Scanner entrada = new Scanner(System.in);

    /**
     * @param nro_tarjeta Esta variable guarda el numero de la tarjeta de credito de la persona.
     * @param tipo Esta variable guarda el tipo que es la tarjeta, que solo podra ser Visa, Mastercard y Maestro.
     */
    private String nro_tarjeta;
    private String tipo;

    public TarjetaCredito() {
        validarTarjeta();
        setTipo();

    }

    public String getNro_tarjeta() {
        return nro_tarjeta;
    }

    public void setNro_tarjeta(String nro_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo() {

        do {
            System.out.println("Introduce el tipo de la tarjeta:");
            tipo = entrada.next();

            if(!tipo.equalsIgnoreCase("VISA") && !tipo.equals("MASTERCARD") && !tipo.equals("MAESTRO")) {
                System.out.println("Tipo de tarjeta inválido, vuelve a intentarlo.");
            }
        }while(!tipo.equalsIgnoreCase("VISA") && !tipo.equals("MASTERCARD") && !tipo.equals("MAESTRO"));
    }

    /**
     * Este metodo sirve para validar si la tarjeta de credito es correcta.
     */
    public void validarTarjeta() {

        System.out.println("Validando...");

        do {
            System.out.println("Introduce el número de la tarjeta:");
            nro_tarjeta = entrada.next();

            if(nro_tarjeta.length() != 16) {
                System.out.println("Número de tarjeta inválido, vuelve a introducirlo.");
            }
        }while(nro_tarjeta.length() != 16);
    }

    @Override

    public void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + "€ con tarjeta de crédito " + tipo);
    }

    @Override

    public String toString() {
        return "[Número de tarjeta = " + nro_tarjeta + ", tipo de tarjeta = " + tipo + "]";
    }
}
