package org.example;

import static org.junit.jupiter.api.Assertions.*;

class Acensorv2Test {

    @org.junit.jupiter.api.Test
    void casoDePrueba1() {

        int[] ascensor = {0,2,5,2,6,7};
        int resultado = 0;

        for (int i = 0; i < ascensor.length - 1; i++) {

            int num = (ascensor[i] - ascensor[i + 1]);

            if (num < 0) {
                num *= -1;
            }

            resultado += num;
        }

        assertEquals(13, resultado);


    }

    @org.junit.jupiter.api.Test
    void casoDePrueba2() {

        int tamanyo = 6;
        String[] vector = {"0","2","5","2","6","7","-1","2","2"};
        int contador = 0;

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

        assertEquals(tamanyo, contador);
    }

    @org.junit.jupiter.api.Test
    void casosDePrueba3() {

        boolean resultado = true;
        int[] ascensor = {-1,2,5,2,6,7};
        int contador = 0;

        for (int i = 0; i < ascensor.length; i++) {

            if (ascensor[0] == -1) {
                contador++;
                break;
            }else if (ascensor[i] == -1) {
                break;
            }else{
                contador++;
            }
        }

        if (ascensor[0] < 0) {
            resultado = false;
        }

        assertFalse(resultado);
        assertEquals(1, contador);
    }
}