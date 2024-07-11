package com.alurapractice.challengebooksearch;

import java.util.Scanner;

public class ShowMenu {
    Scanner teclado = new Scanner(System.in);
    private String menu = """
            Elija la opción que desea ejecutar:
            1.Buscar libro por titulo
            2.Listar libros registrados
            3.Listar autores registrados
            4.Listar autores vivos en un determinado año
            5.Listar libros por idioma
            6.Salir""";
    public void getshowMenu(){
        System.out.println(menu);
        int menuOption = Integer.valueOf(teclado.nextLine());

        switch (menuOption){
            case 1:

        }
    }



}
