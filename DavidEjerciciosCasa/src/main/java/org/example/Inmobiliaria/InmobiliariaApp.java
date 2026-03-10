package org.example.Inmobiliaria;

public class InmobiliariaApp {

    public static void main(String[] args) {

        Casa pisito = new Casa("Calle Falsa 1 2 3");

        pisito.crearHabitacion("cocina",30);
        pisito.crearHabitacion("baño",10);

        pisito.mostrarHabitaciones();

        System.out.println("La habitación más grande es " + pisito.getHabitacionMasGrande().getNombre() + " con " + pisito.getHabitacionMasGrande().getMetros() + " metros.");

        pisito.crearHabitacion("baño",15);

        pisito.eliminarHabitacion("terraza");
        pisito.eliminarHabitacion("cocina");

        System.out.println(pisito.getListaHabitaciones());

        pisito.getListaHabitaciones().get(0).insertarElectrodomestico("secador",20);
        pisito.getListaHabitaciones().get(0).insertarElectrodomestico("plancha",10);
        pisito.getListaHabitaciones().get(0).mostrarElectrodomesticos();
        System.out.println("Consumo en la habitación " + pisito.getListaHabitaciones().get(0).getNombre() + ": " + pisito.getListaHabitaciones().get(0).calcularConsumo() + "kwh");

        System.out.println("La habitación que más consume es " + pisito.habitacionMasConsumo().getNombre());

    }
}
