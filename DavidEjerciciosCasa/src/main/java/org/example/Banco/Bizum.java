package org.example.Banco;
import java.util.Random;
import java.util.Scanner;

/**
 * @author David Giner
 */
public class Bizum extends MetodoPago{
    static Scanner entrada = new Scanner(System.in);
    static Random random = new Random();

    /**
     * @param telefono Esta variable sirve para guardar el numero de telefono.
     * @param pin Esta variable sirve para guardar un codigo de 6 digitos autogenerado.
     */
    private String telefono;
    private int pin;

    public Bizum() {

        setTelefono();
        setPin();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono() {

        do {
            System.out.println("Introduce el número de teléfono:");
            telefono = entrada.next();

            if(telefono.length() != 9) {
                System.out.println("Teléfono incorrecto, vuelve a introducirlo.");
            }
        }while(telefono.length() != 9);
    }

    public int getPin() {
        return pin;
    }

    public void setPin() {

        String digitos = "";

        for(int i = 0; i < 6; i++) {

            int num = random.nextInt(10);

            if (num == 0) {
                String cero = Integer.toString(num);
                digitos += cero;
            }else{
                digitos += num;
            }
        }

        pin = Integer.parseInt(digitos);
    }

    /**
     * Este metodo sirve para validar si el Bizum es correcto
     * @return El metodo devolvera true si el pin y el telefono son correctos, en caso contrario devolvera false
     */
    public boolean validarBizum() {

        System.out.println(getPin());

        System.out.println("Validando...");

        System.out.println("Introduce tu PIN:");
        int num = entrada.nextInt();

        if (telefono.length() == 9 && num == pin) {

            return true;
        }

        return false;
    }

    @Override

    public void procesarPago(double importe) {

        if(validarBizum()) {
            System.out.println("Procesando pago de importe " + importe + "€ con Bizum.");
        }else if(telefono.length() != 9) {
            System.out.println("ERROR: El número de teléfono es incorrecto.");
        }else{
            System.out.println("PIN incorrecto, pago cancelado.");
        }
    }
}
