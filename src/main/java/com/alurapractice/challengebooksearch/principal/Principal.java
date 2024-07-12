package com.alurapractice.challengebooksearch.principal;

import com.alurapractice.challengebooksearch.mapper.BookDTO;
import com.alurapractice.challengebooksearch.mapper.Data;
import com.alurapractice.challengebooksearch.service.APIConsumer;
import com.alurapractice.challengebooksearch.service.BookService;
import com.alurapractice.challengebooksearch.service.DataConverter;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    Scanner teclado = new Scanner(System.in);
    BookService bookService = new BookService();
    APIConsumer apiConsumer = new APIConsumer();
    DataConverter dataConverter = new DataConverter();
    private final String URL_BASE = "https://gutendex.com/books/";


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
                    getBookByTitle();
                    break;
                case 2:
                    getBooks();
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        }

    }
    public void getBookByTitle() {
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var bookTitle = teclado.nextLine();
        var json = apiConsumer.getData(URL_BASE + "?search=" + bookTitle.replace(" ","+"));
        Data datos = dataConverter.getData(json, Data.class);

        Optional<BookDTO> bookInfo = datos.dataResults().stream()
                .filter(l -> l.name().toUpperCase().contains(bookTitle.toUpperCase()))
                .findAny();
        if (bookInfo.isPresent()){
            System.out.println(bookInfo.get());
        }else {
            System.out.println("Libro no encontrado");
        }
    }

    public void getBooks(){
        var json = apiConsumer.getData(URL_BASE);
        Data datos = dataConverter.getData(json, Data.class);
        List<BookDTO> books = datos.dataResults();
        System.out.println(books);
    }


}
