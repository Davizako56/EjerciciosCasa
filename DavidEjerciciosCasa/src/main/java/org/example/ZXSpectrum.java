package org.example;
import java.util.Scanner;

public class ZXSpectrum {


    static void main() {
        Scanner entrada = new Scanner(System.in);

        //En esta parte inicializo las variables.

        int ancho = 0;
        int alto = 0;
        boolean err;

        System.out.println("******* VALIDADOR DE COMPATIBILIDAD ZX SPECTRUM *******");

        //Do-While y try-catch para que a la hora de introducir el ancho y el alto de la matriz se respete tanto el formato de la entrada como sus límites.

        do {

            err = true;

            while(err) {

                try{
                    System.out.println("Introduce la resolución de tu pantalla (ancho x alto):");
                    System.out.println("Ancho:");
                    ancho = entrada.nextInt();
                    System.out.println("Alto:");
                    alto = entrada.nextInt();
                    err = false;
                }catch(Exception e) {
                    System.out.println("ERROR: El programa no admite texto");
                    entrada.nextLine();
                }
            }



            if (ancho % 8 != 0 || alto % 8 != 0) {

                System.out.println("ERROR: El tamaño debe de ser múltiplo de 8");
            }
        }while (ancho % 8 != 0 || alto % 8 != 0);

        System.out.println("Introduce (línea a línea) los colores de tu imagen para cada pixel:");

        //Bucle for junto con vector para poder añadir las letras en la matriz a modo de línea

        String[][] pantalla = new String[alto][ancho];

        for (int i = 0; i < alto; i++) {

            String fila = entrada.next();

            if (ancho != fila.length()) {

                System.out.println("ERROR: La fila no puede ser diferente del ancho de la pantalla.");
                i--;
            }else{

                String[] letra = fila.split("");

                for (int j = 0; j < ancho; j++) {

                    pantalla[i][j] = letra[j];

                    if (!pantalla[i][j].matches("[a-oA-O]")) {

                        System.out.println("Has introducido un valor de pixel incorrecto (A-O)");
                        i--;
                        break;
                    }
                }


            }
        }

        //Bucle for creado para imporimir la matriz.

        for (int i = 0; i < alto; i++) {

            for (int j = 0; j < ancho; j++) {

                System.out.print(pantalla[i][j] + " ");
            }

            System.out.println();
        }

        //Serie de bucles y variables hechos para comporbar si la pantalla de carga es compatible o no.

        int i = 0;
        int j = 0;

        while (true) {

            String[] letras = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
            int contador = 0;

            for (int x = i; x < (i + 8); x++) {

                if (contador > 2) {
                    System.out.println("No es compatible con un ZX Spectrum");
                    return;
                }

                for (int y = j; y < (j + 8); y++) {

                    for (int z = 0; z < letras.length; z++) {

                        if (pantalla[x][y].equalsIgnoreCase(letras[z])) {

                            letras[z] = "-";
                            contador++;
                        }
                    }
                }
            }


            j += 8;

            if (j == ancho) {
                break;
            }
        }

        System.out.println("Es compatible con un ZX Spectrum");


    }
}

