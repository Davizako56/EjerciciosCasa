package org.example.Inmobiliaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Casa {

    static Scanner teclado = new Scanner(System.in);

    private String direccion;
    private ArrayList<Habitacion> listaHabitaciones;
    private Propietario propietario;

    public Casa (String direccion){
        this.direccion=direccion;
        setPropietario();
        listaHabitaciones = new ArrayList<>();
    }

    public void crearHabitacion (String nombre, double metros){

        for (Habitacion habitacion : listaHabitaciones){

            if (habitacion.getNombre().equals(nombre)){
                System.out.println("La habitación " + nombre + " ya existe.");
                return;
            }

        }

        Habitacion habitacion = new Habitacion(nombre,metros);
        listaHabitaciones.add(habitacion);
        System.out.println("Nueva habitación añadida.");

    }

    public void eliminarHabitacion (String nombre){

        for (Habitacion habitacion : listaHabitaciones){

            if (habitacion.getNombre().equals(nombre)){
                listaHabitaciones.remove(habitacion);
                System.out.println("Habitación eliminada.");
                return;
            }

        }

        System.out.println("La habitación no existe. No se puede eliminar.");

    }

    public void mostrarHabitaciones (){

        System.out.println("Habitaciones de la casa en la dirección " + direccion + " cuyo dueño es " + propietario.getNombre());

        for (Habitacion habitacion : listaHabitaciones){
            System.out.println("- " + habitacion.getNombre() + " (" + habitacion.getMetros() + "m2)");
        }

    }

    public Habitacion getHabitacionMasGrande (){

        Habitacion grande = listaHabitaciones.get(0);

        for (Habitacion habitacion : listaHabitaciones){
            if (habitacion.getMetros() > grande.getMetros()){
                grande = habitacion;
            }
        }
        return grande;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public Habitacion habitacionMasConsumo (){

        Habitacion maximo = listaHabitaciones.get(0);

        for (Habitacion habitacion : listaHabitaciones){
            if (habitacion.calcularConsumo()>maximo.calcularConsumo()){
                maximo=habitacion;
            }
        }

        return maximo;

    }

    public void setPropietario() {
        System.out.println("Introduce el nombre del propietario: ");
        String nombre = teclado.next();
        teclado.nextLine();
        System.out.println("Edad: ");
        int edad = teclado.nextInt();
        teclado.nextLine();
        propietario=new Propietario(nombre,edad);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "direccion='" + direccion + '\'' +
                ", listaHabitaciones=" + listaHabitaciones +
                ", propietario=" + propietario +
                '}';
    }




}
