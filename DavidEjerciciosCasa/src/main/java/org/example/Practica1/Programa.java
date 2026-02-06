package org.example.Practica1;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class Programa {
    static Scanner entrada = new Scanner(System.in);

    private String nombre;
    private Cadena cadena;
    private int temporadas;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Invitado> listaInvitados;
    private Empleado director;

    public Programa(String nombre, Cadena cadena) {

        this.nombre = nombre;
        this.cadena = cadena;
        temporadas = 0;
        setDirector();
        listaEmpleados = new ArrayList<>();
        listaInvitados = new ArrayList<>();
        listaEmpleados.add(director);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cadena getCadena() {
        return cadena;
    }

    public void setCadena(Cadena cadena) {
        this.cadena = cadena;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Invitado> getListaInvitados() {
        return listaInvitados;
    }

    public void setListaInvitados(ArrayList<Invitado> listaInvitados) {
        this.listaInvitados = listaInvitados;
    }

    public Empleado getDirector() {
        return director;
    }

    public void setDirector() {

        System.out.println("Introduce el nombre del director:");
        String nombre = entrada.next();

        Empleado director = new Empleado(nombre, "director", null);
        this.director = director;
    }

    public void anyadirEmpleado(String nombre, String cargo, Empleado director) {

        for (Empleado e : listaEmpleados) {

            if (nombre.equalsIgnoreCase(e.getNombre()) && cargo.equalsIgnoreCase(e.getCargo()) && director == e.getDirector()) {
                System.out.println("Este empleado ya es parte de este programa.");
                return;
            }
        }

        if (cargo.equalsIgnoreCase("director")) {
            System.out.println("Este programa ya tiene un director.");
        }else{
            Empleado empleado = new Empleado(nombre, cargo, director);
            listaEmpleados.add(empleado);
            System.out.println("Empleado contratado para el programa.");
        }

    }

    public void borrarEmpleado(String nombre, String cargo) {

        for (Empleado e : listaEmpleados) {

            if (nombre.equalsIgnoreCase(e.getNombre()) && cargo.equalsIgnoreCase(e.getCargo())) {
                listaEmpleados.remove(e);
                System.out.println("Empleado despedido del programa.");
                return;
            }
        }

        System.out.println("Este empleado no esta dentro del programa.");
    }

    public void anyadirInvitado(String nombre, String profesion, LocalDate fecha_visita, int temporada) {

        for (Invitado i : listaInvitados) {

            if (nombre.equalsIgnoreCase(i.getNombre()) && profesion.equalsIgnoreCase(i.getProfesion()) && fecha_visita == i.getFecha_visita() && temporada == i.getTemporada()) {
                System.out.println("Este invitado ya esta invitado al programa");
                return;
            }
        }

        Invitado invitado = new Invitado(nombre, profesion, fecha_visita, temporada);
        listaInvitados.add(invitado);
        System.out.println("Invitado agregado al programa.");
    }

    public void borrarInvitado(String nombre, String profesion, int temporada) {

        for (Invitado i : listaInvitados) {

            if (nombre.equalsIgnoreCase(i.getNombre()) && profesion.equalsIgnoreCase(i.getProfesion()) && temporada == i.getTemporada()) {
                listaInvitados.remove(i);
                System.out.println("Invitado borrado.");
                return;
            }
        }

        System.out.println("Este invitado no esta invitado al programa.");
    }

    @Override

    public String toString() {

        return "[nombre = " + nombre + ", cadena = " + cadena + ", temporadas = " + temporadas + ", director = " + director + "]";
    }

}
