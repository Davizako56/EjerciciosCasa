package org.example;
import java.util.Arrays;
import java.util.Scanner;

public class Ascensorv1 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String[] vector;

        do {
            int contador = 0;
            int resultado = 0;

            System.out.println("Indica el recorrido del ascensor");
            String pisos = entrada.nextLine();

            vector = pisos.split(" ");

            if (!vector[0].equals("-1")) {

                for (String i : vector) {

                    if (i.equals("-1")) {
                        break;
                    }else{
                        contador++;
                    }
                }

                int[] ascensor = new int[contador];

                for (int i = 0; i < vector.length; i++) {
                    int num = Integer.parseInt(vector[i]);
                    ascensor[i] = num;

                    if (vector[i + 1].equals("-1")){
                        break;
                    }

                }

                System.out.println("Recorrido de ascensor: " + Arrays.toString(ascensor));

                for (int i = 0; i < ascensor.length - 1; i++) {

                    int num = (ascensor[i] - ascensor[i + 1]);

                    if (num < 0) {
                        num *= -1;
                    }

                    resultado += num;
                }

                System.out.println("El ascensor ha recorrido " + (resultado == 1 ? resultado + " piso" : resultado + " pisos"));
            }



        }while (!vector[0].equals("-1"));

    }
}
