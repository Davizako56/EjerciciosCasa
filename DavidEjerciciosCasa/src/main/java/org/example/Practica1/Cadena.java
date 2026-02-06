package org.example.Practica1;
import java.util.ArrayList;

public class Cadena {

    private String nombre;
    private ArrayList<Programa> listaProgramas;

    public Cadena(String nombre) {

        this.nombre = nombre;
        listaProgramas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Programa> getListaProgramas() {
        return listaProgramas;
    }

    public void setListaProgramas(ArrayList<Programa> listaProgramas) {
        this.listaProgramas = listaProgramas;
    }

    public void anyadirPrograma(Programa programa) {

        for (Programa p : listaProgramas) {

            if (programa == p) {
                System.out.println("Este programa ya esta en la cadena");
                return;
            }
        }

        listaProgramas.add(programa);
        System.out.println("Programa insertado en esta cadena.");
    }

    public void borrarPrograma(Programa programa) {

        for (Programa p : listaProgramas) {

            if (programa == p) {
                listaProgramas.remove(p);
                System.out.println("Programa eliminado de la cadena.");
                return;
            }
        }

        System.out.println("Este programa no existe dentro de la cadena.");
    }

    @Override

    public String toString() {

        return "[nombre = " + nombre + "]";
    }
}
