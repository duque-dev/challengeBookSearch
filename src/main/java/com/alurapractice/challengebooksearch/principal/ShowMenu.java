package com.alurapractice.challengebooksearch.principal;

import com.alurapractice.challengebooksearch.service.APIConsumer;
import com.alurapractice.challengebooksearch.service.BookService;
import com.alurapractice.challengebooksearch.service.DataConverter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ShowMenu {
    Scanner teclado = new Scanner(System.in);

    BookService bookService = new BookService();


    public void setMenu() {
        var menuOption = -1;
        while (menuOption != 0) {
            String menu = """
                    Elija la opción que desea ejecutar:
                    1.Buscar libro por titulo
                    2.Listar libros registrados
                    3.Listar autores registrados
                    4.Listar autores vivos en un determinado año
                    5.Listar libros por idioma
                    6.Salir""";
            System.out.println(menu);
            menuOption = Integer.valueOf(teclado.nextLine());

            switch (menuOption) {
                case 1:
                    bookService.getBookByTitle();
                    break;
                case 2:
                    //buscarEpisodioPorSerie();
                    break;

                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        }

    }

}
