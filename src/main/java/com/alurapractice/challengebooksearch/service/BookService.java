package com.alurapractice.challengebooksearch.service;

import com.alurapractice.challengebooksearch.model.BookDTO;

import java.util.Scanner;

public class BookService {
    Scanner teclado = new Scanner(System.in);
    APIConsumer apiConsumer = new APIConsumer();
    DataConverter dataConverter = new DataConverter();
    private final String URL_BASE = "https://gutendex.com/books";

    public BookDTO getBookByTitle() {
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var bookId = Integer.valueOf(teclado.nextLine());
        var json = apiConsumer.getData(URL_BASE + "/" + bookId);
        System.out.println(json);
        BookDTO datos = dataConverter.getData(json, BookDTO.class);
        return datos;
    }
}
