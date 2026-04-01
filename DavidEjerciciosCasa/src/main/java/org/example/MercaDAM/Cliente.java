package org.example.MercaDAM;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que define los métodos de la clase cliente y como esta se va a comportar.
 * @author David Giner
 */

public class Cliente {

    private String usuario;
    private String contraseña;
    private String direccion;
    private Pedido pedido;
    private boolean promocion;

    public Cliente(String usuario, String contraseña) {

        this.usuario = usuario;
        this.contraseña = contraseña;
        direccion = "Calle falsa, 123";
        pedido = null;
        promocion = false;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public boolean isPromocion() {
        return promocion;
    }

    public void setPromocion(boolean promocion) {
        this.promocion = promocion;
    }

    /**
     * Método que crea un pedido para el cliente en concreto.
     */
    public void crearPedido() {

        pedido = new Pedido();

    }

    /**
     * Método para insertar prodcutos en el pedido del cliente.
     * @param producto Parámetro que indica el prodcuto que va a ser añadido al pedido.
     */
    public void insertarProducto(Producto producto) {

        HashMap<Producto, Integer> lista = new HashMap<>();

        for(Map.Entry<Producto, Integer> mapita : pedido.getPedido().entrySet()) {

            if(mapita.getKey() == producto) {
                lista.put(producto, mapita.setValue(mapita.getValue() + 1));
                pedido.setPedido(lista);
                pedido.actualizarImporteTotal(producto.getPrecio());
            }else{
                lista.put(producto, 1);
                pedido.setPedido(lista);
                pedido.actualizarImporteTotal(producto.getPrecio());
            }
        }
    }

    @Override

    public String toString() {

        return "[Usuario = " + usuario + ", contraseña = " + contraseña + ", dirección = " + direccion + ", pedido = " + pedido + ", promoción = " + promocion + "]";
    }
}
