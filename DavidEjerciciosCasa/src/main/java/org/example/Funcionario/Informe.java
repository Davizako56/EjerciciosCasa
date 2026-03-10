package org.example.Funcionario;

public class Informe {

    private static int contador = 0;

    private int codigo;
    private String descripcion;
    private Tipo tipo;

    public Informe(String descripcion, Tipo tipo) {
        contador++;
        setCodigo();
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo() {
        codigo = contador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override

    public String toString() {

        return "[Código = " + codigo + ", descripción = " + descripcion + ", tipo = " + tipo + "]";
    }
}
