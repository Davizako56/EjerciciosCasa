package org.example;
import java.util.Scanner;

public class ISBN {

    static void main() {
        Scanner entrada = new Scanner(System.in);

        //Inicializo las variables que se usarán en el código.

        int contador = 10;
        int marca = 0;
        int num;
        int resultado = 0;

        //En esta parte del código le pido al usuario que introduzca el ISBN a validar.

        System.out.println("Introduzca ISBN:");
        String isbn = entrada.next();

        //Este if sirve para comprobar que el ISBN introducido tiene una longitud de 10 caracteres en total

        if (isbn.length() != 10) {
            System.out.println("El ISBN no encaja con el formato.");
        }else{

            //Este for sirve para ir sumando gradualmente en la variable resultado las multiplicaciones hechas para cada dígito del ISBN, con algunos ifs para controlar cosas como que la X este en el último dígito del ISBN o guardar la posición de un caso "?".

            for (int i = 0; i < 10; i++) {

                String sub = isbn.substring(i, i + 1);

                if (sub.equals("?")) {
                    marca = contador;
                    contador--;

                }else if (sub.equals("X")) {

                    if (contador == 1) {
                        resultado += 10;
                    }else{
                        System.out.println("El ISBN no encaja con el formato.");
                        return;
                    }

                }else {
                    try{
                        num = Integer.parseInt(sub);
                        resultado += (num * contador);
                        contador--;
                    }catch (Exception e){
                        System.out.println("El ISBN no encaja con el formato");
                        return;
                    }
                }
            }

            //Este for sirve para que en caso de que haya una interrogación en el ISBN que pueda indicar que número falta (Es el reparador de ISBNs).

            for (int i = 0; i < 10; i++) {

                String sub = isbn.substring(i, i + 1);

                if (sub.equals("?")) {

                    for (int j = 1; j <= 10; j++) {

                        if ((resultado + (j * marca)) % 11 == 0) {
                            System.out.println("El digito que falta es " + j);
                        }
                    }
                    return;
                }
            }

            //Este último if-else sirve para validar el ISBN.

            if (resultado % 11 == 0) {
                System.out.println("El ISBN es valido");
            }else{
                System.out.println("El ISBN no es valido");
            }
        }
    }


}
