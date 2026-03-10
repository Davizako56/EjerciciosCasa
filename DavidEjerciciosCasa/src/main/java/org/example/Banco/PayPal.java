package org.example.Banco;

/**
 * @author David Giner
 */
public class PayPal extends MetodoPago{

    /**
     * @param formato_cuenta Es la constante que sirve como plantilla para el formato de las cuentas.
     * @param cuenta Es la variable que guardara la cuenta de la persona que utilice PayPal.
     * @param saldo Es la variable que indicara cuanto dinero tiene la persona en la cuenta.
     */
    private static final String formato_cuenta = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+.com$";
    private String cuenta;
    private double saldo;

    public PayPal(String cuenta, double saldo) {

        this.cuenta = cuenta;
        this.saldo = saldo;
    }

    public PayPal() {
        saldo = 23;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Este metodo sirve para validar si el PayPal es correcto.
     * @param importe Esta variable tomara el dinero que le pasemos por teclado para compararlo con el saldo y comprobar si se puede realizar el pago.
     * @return El metodo devolvera true si el importe es menor que el saldo y el formato de la cuenta es correcta y false en caso contrario.
     */
    public boolean validarPayPal(double importe) {

        System.out.println("Validando...");

        if(cuenta.matches(formato_cuenta) && saldo >= importe) {
            return true;
        }

        return false;
    }

    @Override

    public void procesarPago(double importe) {

        if(validarPayPal(importe)) {
            System.out.println("Procesando pago de importe " + importe + "€ con PayPal.");
        }else if(!cuenta.matches(formato_cuenta)) {
            System.out.println("ERROR: La cuenta de PayPal no existe");
        }else{
            System.out.println("ERROR: Saldo insuficiente.");
        }
    }

    @Override

    public String toString() {

        return "[Cuenta = " + cuenta + ", saldo = " + saldo + "]";
    }
}