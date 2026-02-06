package org.example.Practica1;

public class AppProgramas {

    public static void main(String[] args) {

        Cadena antena3 = new Cadena("antena 3");

        Programa el_hormiguero = new Programa("El Hormiguero", antena3);
        System.out.println(el_hormiguero);
        System.out.println(antena3);


        el_hormiguero.anyadirEmpleado("Pablo Motos","presentador",null);
        System.out.println(el_hormiguero);
        System.out.println();

        System.out.println(el_hormiguero.getListaEmpleados());
        System.out.println();

        //el_hormiguero.anyadirInvitado("Aitana","cantante",1);
        System.out.println(el_hormiguero.getListaInvitados());
    }
}
