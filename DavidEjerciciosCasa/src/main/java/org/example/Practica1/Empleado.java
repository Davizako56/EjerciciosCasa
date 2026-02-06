package org.example.Practica1;

public class Empleado {

    private int contador = 0;

    private String id;
    private String nombre;
    private String cargo;
    private Empleado director;

    public Empleado(String nombre, String cargo, Empleado director) {

        ++contador;
        id = generarId(contador);
        this.nombre = nombre;
        this.cargo = cargo;
        setCargo(cargo);

        if (cargo.equalsIgnoreCase("director")) {
            this.director = null;
        }else{
            this.director = director;
        }
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {

        if (!cargo.equalsIgnoreCase("director") && !cargo.equalsIgnoreCase("tecnico") && !cargo.equalsIgnoreCase("presentador") && !cargo.equalsIgnoreCase("colaborador")) {
            this.cargo = "pte";
        }else{
           this.cargo = cargo;
        }
    }

    public Empleado getDirector() {
        return director;
    }

    public void setDirector(Empleado director) {
        this.director = director;
    }

    public String generarId(int contador) {

        if (contador < 10) {
            return "EP00" + contador;
        }else if (contador < 100) {
            return "EP0" + contador;
        }else{
            return "EP" + contador;
        }
    }

    @Override

    public String toString() {

        return "[id = " + id + ", nombre = " + nombre + ", cargo = " + cargo + ", director = " + director + "]";
    }
}
