package org.example.Inmobiliaria;

import java.util.ArrayList;

public class Habitacion {

    private String nombre;
    private double metros;
    private ArrayList<Electrodomestico> listaElectrodomesticos;

    public Habitacion (String nombre, double metros){
        this.metros=metros;
        this.nombre=nombre;
        listaElectrodomesticos = new ArrayList<>();
    }

    public void insertarElectrodomestico(String nombre, double consumo){
        Electrodomestico electrodomestico =  new Electrodomestico(nombre,consumo);
        listaElectrodomesticos.add(electrodomestico);
        System.out.println(nombre + " añadido.");
    }

    public void mostrarElectrodomesticos(){

        System.out.println("Electrodomésticos de la habitación " + nombre);

        for (Electrodomestico electrodomestico : listaElectrodomesticos){

            System.out.println("- " + electrodomestico.getNombre() + " con un consumo de " + electrodomestico.getConsumo() + "kwh");

        }

    }

    public double calcularConsumo(){
        double consumo = 0;
        for (Electrodomestico electrodomestico : listaElectrodomesticos){
            consumo += electrodomestico.getConsumo();
        }
        return consumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMetros() {
        return metros;
    }

    public void setMetros(double metros) {
        this.metros = metros;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "nombre='" + nombre + '\'' +
                ", metros=" + metros +
                ", electrodomesticos=" + listaElectrodomesticos +
                '}';
    }



}
