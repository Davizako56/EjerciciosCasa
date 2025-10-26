package org.example;
import java.util.Scanner;

public class Calculadora {

    static void main() {
        Scanner entrada = new Scanner(System.in);

        //Introduzco e inicializo las variables a usar en el programa.

        double num1 = 0;
        double num2 = 0;
        double respuesta;
        String operacion = "";
        boolean err;

        //El codigo entero esta dentro de un do-while para controlar que la operacion introducida (+,-,x,/,R) sea correcta.

        do {

            //El try-catch es para que la entrada de los numeros no admita texto sin que cierre abruptamente el programa.

            err = true;
            while (err) {
                try {
                    System.out.println("**** BIENVENIDO A LA CALCULADORA RAPIDA ****");
                    System.out.println("> Introduce un operando:");
                    num1 = entrada.nextInt();
                    System.out.println("----------------------------------------------------");
                    System.out.println("[+] -> sumar");
                    System.out.println("[-] -> restar");
                    System.out.println("[x] -> multiplicar");
                    System.out.println("[/] -> dividir");
                    System.out.println("[R] -> raiz cuadrada");
                    System.out.println("---------------------------------------------------");
                    System.out.println("Elige una operacion:");
                    operacion = entrada.next();
                    System.out.println("> Introduce el segundo operando:");
                    num2 = entrada.nextInt();
                    err = false;
                }catch (Exception e){
                    System.out.println("ERROR: El programa no admite texto");
                    entrada.nextLine();
                }
            }

            //El switch-case es para que el programa sepa que operacion hacer segun lo que hayamos introducido.

            switch(operacion) {

                case "+":
                    respuesta = num1 + num2;
                    System.out.println("El resultado de " + num1 + " + " + num2 + " es " + respuesta);
                    break;

                case "-":
                    respuesta = num1 - num2;
                    System.out.println("El resultado de " + num1 + " - " + num2 + " es " + respuesta);
                    break;

                case "x":
                    respuesta = num1 * num2;
                    System.out.println("El resultado de " + num1 + " x " + num2 + " es " + respuesta);
                    break;

                case "/":

                    //Este if sirve para prevenir que se pueda dividir entre 0.

                    if (num2 == 0) {
                        System.out.println("ERROR: No se puede dividir entre 0");
                    } else {
                        respuesta = num1 / num2;
                        System.out.println("El resultado de " + num1 + " / " + num2 + " es " + respuesta);
                    }
                    break;

                case "R":
                    respuesta = Math.sqrt(num1);
                    System.out.println("El resultado de la raiz cuadrada de " + num1 + " es " + respuesta);
                    break;
            }

            //El if es para que salte un mensaje en caso de que la operacion introducida no exista.

            if (!operacion.equals("+") && !operacion.equals("-") && !operacion.equals("x") && !operacion.equals("/") && !operacion.equals("R")) {
                    System.out.println("El operando no encaja, vuelva a intentarlo");
            }


        }while (!operacion.equals("+") && !operacion.equals("-") && !operacion.equals("x") && !operacion.equals("/") && !operacion.equals("R"));
    }
}
