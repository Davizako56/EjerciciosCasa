package org.example;
import java.util.Scanner;

/**
 * @author David Giner
 * @version v2
 * Este codigo trata de plasmar en un array el recorrido de un ascensor en pisos (terminando el array en -1) para despues contar cuantos pisos en total ha subido y bajado el ascensor, el programa terminara cuando se escriba un -1.
 */

public class Acensorv2 {
    static Scanner entrada = new Scanner(System.in);

    /**
     *El metodo main contiene una estructura de control (bucle while) que sirve para que el codigo del siguiente metodo se siga ejecutando hasta que devuelva false
     */

    public static void main(String[] args) {

        while (casoDePrueba()) {

        }
    }

    /**
     * Este metodo es el que contiene el codigo funcional y el cual se ejecuta en el metodo main.
     * @return true/false
     */

    static boolean casoDePrueba() {

        /**
         * <code>contador:</code> Lo utilizo para definir el tamaño del array ascensor
         * <code>resultado:</code> Es la variable que acumula y guarda los pisos subidos o bajados por el ascensor
         * <code>vector:</code> Es el array que utilizo para guardar la variable <code>pisos</code> con un split para despues pasarlo como int al array <code>ascensor</code>
         */

        int contador = 0;
        int resultado = 0;

        String pisos = entrada.nextLine();

        String[] vector = pisos.split(" ");

        for (int i = 0; i < vector.length; i++) {

            if (vector[0].equals("-1")) {
                contador++;
                break;
            }else if (vector[i].equals("-1")) {
                break;
            }else{
                contador++;
            }
        }

        int[] ascensor = new int[contador];

        for (int i = 0; i < vector.length; i++) {

            /**
             * <code>num:</code> Lo utilizo para pasar a int las posiciones del array <code>vector</code> y plasmarlas en el array <code>ascensor</code>
             */

            int num = Integer.parseInt(vector[i]);
            ascensor[i] = num;

            if (ascensor[i] == -1 || vector[i + 1].equals("-1")) {
                break;
            }

        }

        if (ascensor[0] < 0) {
            return false;
        }else{

            for (int i = 0; i < ascensor.length - 1; i++) {

                /**
                 * <code>num:</code> En este caso esta variable num la utilizo para hacer la operacion para calcular cuantos pisos se mueve el ascensor entre dos paradas y acumularlo a la variable <code>resultado</code>
                 */

                int num = (ascensor[i] - ascensor[i + 1]);

                if (num < 0) {
                    num *= -1;
                }

                resultado += num;
            }

            System.out.println(resultado);

            return true;
        }

    }
}
