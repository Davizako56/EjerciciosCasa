package org.example;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Primitiva {


    static void main() {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();

        //Al principio es donde inicializo todas las variables

        int[] sorteo = new int[6];
        int[] dupe;
        int complementario = random.nextInt(1,50);
        int reintegro = random.nextInt(10);
        String[] vector;
        int[] boleto = new int[7];
        int contador = 0;
        boolean rein = false;
        boolean comp = false;

        //Este do-while sirve para controlar que no hayan duplicados en el array sorteo

        do {
            for (int i = 0; i < sorteo.length; i++) {

                int num = random.nextInt(1,50);
                sorteo[i] = num;

                if (sorteo[i] == complementario) {
                    complementario = random.nextInt(1,50);
                    i = 0;
                }
            }

            dupe = Arrays.stream(sorteo).distinct().toArray();


        }while(dupe.length < sorteo.length);

        System.out.println(Arrays.toString(sorteo));
        System.out.println("Reintegro: " + reintegro);
        System.out.println("Complementario: " + complementario);

        //Aqui pido los datos del boleto y en el siguiente if compruebo que el formato sea correcto

        System.out.println("Introduce los datos de tu boleto:");
        String datos = entrada.next();

        if (datos.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}/\\d")) {

            vector = datos.split("[/-]");

            //Estos dos bucles for sirven para saber cuantos números del boleto coinciden con los del sorteo

            for (int i = 0; i < vector.length; i++) {

                String pos = vector[i];
                int num = Integer.parseInt(pos);

                boleto[i] = num;
            }

            System.out.println("SORTEO:");
            System.out.println(Arrays.toString(sorteo));
            System.out.println("Complementario: " + complementario);
            System.out.println("Reintegro: " + reintegro);

            for (int i = 0; i < boleto.length - 1; i++) {

                if (boleto[i] == complementario) {
                    comp = true;
                }

                for (int j = 0; j < sorteo.length; j++) {

                    if (boleto[i] == sorteo[j]) {
                        contador++;
                    }
                }
            }

            //Los siguientes if e if-else sirven para saber que categoría toca

            if (boleto[6] == reintegro) {
                System.out.println("Reintegro");
                rein = true;
            }

            if (contador == 6 && rein) {
                System.out.println("Categoria especial");
            }else if (contador == 6){
                System.out.println("Primera categoria");
            }else if (contador == 5 && comp) {
                System.out.println("Segunda categoria");
            }else if (contador == 5) {
                System.out.println("Tercera categoria");
            }else if (contador == 4) {
                System.out.println("Cuarta categoria");
            }else if (contador == 3) {
                System.out.println("Quinta categoria");
            }else{
                System.out.println("No premiado");
            }
        }else{
            System.out.println("ERROR: El boleto no encaja con el formato (N-N-N-N-N-N/N)");
        }


    }


}
