package org.example.MercaDAM;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Clase que funciona como una app para el mercado
 * @author David Giner
 */

public class AppZonaClientes {
    static Scanner entrada = new Scanner(System.in);

    private static Cliente cliente;

    public static void main(String[] args) {

        Mercadam mercado = new Mercadam();
        mercado.generarClientes();
        autenticacion(mercado.getClientes());

    }


    /**
     * Método para autenticarse en la aplicación.
     * @param clientes Parámetro de tipo Set que aporta los clientes que hay registrados para poder inicar sesión correctamente.
     */
    public static void autenticacion(Set<Cliente> clientes) {

        System.out.println("=== COMPRA ONLINE EN MERCADAM ===");

        for(int i = 2; i >= 0; i--) {

            System.out.println("Usuario:");
            String usuario = entrada.next();
            System.out.println("Contraseña:");
            String contraseña = entrada.next();

            for(Cliente c : clientes) {

                if(c.getUsuario().equals(usuario) && c.getContraseña().equals(contraseña)) {
                    System.out.println("Bienvenido, " + usuario);
                    cliente = c;
                    iniciarCompra();
                }
            }

            System.out.println("Credenciales no válidas. Intentos: " + i);
        }

        System.out.println("ERROR DE AUTENTICACIÓN");


    }

    /**
     * Método que crea el pedido al cliente.
     */
    public static void iniciarCompra() {

        System.out.println("Creando nuevo pedido...");
        cliente.crearPedido();
        imprimirProductos();

    }

    /**
     * Método para imprimir la lista de productos y empezar a añadirlos al carrito.
     */
    public static void imprimirProductos() {

        Producto[] productos = Producto.values();
        String producto;
        char opcion = 'N';
        boolean existe;

        do {

            existe = false;
            System.out.println("Elige un producto de la lista...");

            for (Producto pr : productos) {
                System.out.println(pr.name() + ": " + pr.getPrecio() + "€");
            }

            System.out.println("================================");
            System.out.println("Elige un producto:");
            producto = entrada.next();

            for(Producto p : productos) {

                if(p.name().equalsIgnoreCase(producto)) {
                    System.out.println("Has añadido " + p.name() + " con un precio de " + p.getPrecio() + "€");
                    existe = true;
                    cliente.insertarProducto(p);
                    System.out.println("Importe total del pedido: " + cliente.getPedido().getImporteTotal() + "€");
                    System.out.println("¿Quieres añadir más productos?");
                    opcion = entrada.next().toUpperCase().charAt(0);

                    if(opcion == 'N') {
                        imprimirResumen();
                        return;
                    }
                }
            }

            if(!existe) {
                System.out.println("Producto no reconocido. Elige otro...");
            }

        }while(opcion == 'S' || !existe);

    }

    /**
     * Método que imprime el resumen de la compra.
     */
    public static void imprimirResumen() {

        System.out.println("=== RESUMEN DE TU CARRITO DE LA COMPRA ===");
        System.out.println("Productos:");

        for(Map.Entry<Producto, Integer> mapita : cliente.getPedido().getPedido().entrySet()) {

            System.out.println(mapita.getValue() + " " + mapita.getKey().name() + ": " + (mapita.getKey().getPrecio() * mapita.getValue()));
        }
        System.out.println();

        System.out.println("IMPORTE TOTAL: " + cliente.getPedido().getImporteTotal());
        System.out.println();
        System.out.println("===========================================");
        mostrarOpciones();


    }

    /**
     * Método que imprime la despedida del programa.
     */
    public static void imprimirDespedida() {

        System.out.println("=== GRACIAS POR SU PEDIDO ===");
        System.out.println("Lo recibirá en unos días en la dirección " + cliente.getDireccion());

    }

    /**
     * Método que muestra todas las opciones que tiene el cliente despues de realizar el pedido.
     */
    public static void mostrarOpciones() {

        int opcion = 0;

        do{
            System.out.println("Que desea hacer?");
            System.out.println("[1]. Aplicar promos.");
            System.out.println("[2]. Mostrar resumen ordenado por uds.");
            System.out.println("[3]. Terminar pedido");
            opcion = entrada.nextInt();

            switch(opcion) {

                case 1:

                    if(cliente.isPromocion()) {
                        System.out.println("No se pueden aplicar promociones porque el cliente ya tiene una aplicada");
                    }else{
                        cliente.setPromocion(true);
                        cliente.getPedido().aplicarPromo3x2();
                        cliente.getPedido().aplicarPromo10();
                        imprimirResumen();
                    }
                    break;

                case 2:
                    break;

                case 3:
                    imprimirDespedida();
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }while(opcion <= 0 || opcion >= 3);

    }
}
