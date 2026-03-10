package org.example.Funcionario;
import java.util.Stack;

public class AppFuncionario {

    public static void main(String[] args) {

        Stack<Informe> informes = new Stack<>();

        informes.push(new Informe("Ordenar papeles", Tipo.PERSONAL));
        informes.push(new Informe("Gestionar base de datos", Tipo.ADMINISTRATIVO));
        informes.push(new Informe("Hacer meeting", Tipo.EMPRESARIAL));
        informes.push(new Informe("Gestionar facturas", Tipo.ADMINISTRATIVO));
        informes.push(new Informe("Revisar tareas", Tipo.PERSONAL));

        while(!informes.isEmpty()) {

            System.out.println(informes.pop().toString());
        }

        informes.push(new Informe("Escuchar podcast", Tipo.PERSONAL));
        informes.push(new Informe("Modificar plantillas", Tipo.ADMINISTRATIVO));
        informes.push(new Informe("Revisar seguridad", Tipo.EMPRESARIAL));
        System.out.println();

        while(!informes.isEmpty()) {

            System.out.println(informes.pop().toString());
        }
    }
}
