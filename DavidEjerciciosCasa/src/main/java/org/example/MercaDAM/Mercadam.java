package org.example.MercaDAM;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Clase que sirve para la generación automática de clientes para hacer pruebas en la app.
 * @author David Giner
 */

public class Mercadam {
    static Random random = new Random();

    private Set<Cliente> clientes;
    private final String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public Mercadam() {

        clientes = new HashSet<>();
        generarClientes();

    }

    /**
     * Método para generar los clientes que se usarán en la autenticación de la app.
     */
    public void generarClientes() {

        StringBuilder nombre = new StringBuilder();
        StringBuilder contraseña = new StringBuilder();

        for(int i = 0; i < 8; i++) {

            int num = random.nextInt(62);
            String letra = caracteres.substring(num, num + 1);
            nombre.append(letra);
        }

        for(int i = 0; i < 8; i++) {

            int num = random.nextInt(62);
            String letra = caracteres.substring(num, num + 1);
            contraseña.append(letra);
        }

        clientes.add(new Cliente(nombre.toString(), contraseña.toString()));

    }

    public Set<Cliente> getClientes() {
        return clientes;
    }
}
