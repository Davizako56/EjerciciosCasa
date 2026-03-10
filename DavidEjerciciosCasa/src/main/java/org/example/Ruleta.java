package org.example;
import java.util.Scanner;
import java.util.Random;

public class Ruleta {

    static void main() {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();
        int[] tambor = new int[6];
        int contador = 0;

        for (int i = 0; i < tambor.length; i++) {

            int bala = random.nextInt(2);
            tambor[i] = bala;

            if (bala == 1) {
                contador++;
            }
        }

        System.out.println("Hay " + contador + " balas en el tambor.");
        int posicion = random.nextInt(6);
        System.out.println("Disparas el revolver...");

        if (tambor[posicion] == 1) {
            System.out.println("Habia una bala en la posicion " + (posicion + 1) + " del tambor, has perdido.");
        }else{
            System.out.println("No habia una bala en la posicion " + (posicion + 1) + " del tambor, has ganado.");
        }
    }
}
