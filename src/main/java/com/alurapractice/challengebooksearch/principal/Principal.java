package com.alurapractice.challengebooksearch.principal;

import com.alurapractice.challengebooksearch.mapper.AutorDTO;
import com.alurapractice.challengebooksearch.mapper.BookDTO;
import com.alurapractice.challengebooksearch.mapper.Data;
import com.alurapractice.challengebooksearch.model.Autor;
import com.alurapractice.challengebooksearch.model.Book;
import com.alurapractice.challengebooksearch.repository.IAutorRepository;
import com.alurapractice.challengebooksearch.repository.IBookRepository;
import com.alurapractice.challengebooksearch.service.APIConsumer;
import com.alurapractice.challengebooksearch.service.AuthorService;
import com.alurapractice.challengebooksearch.service.BookService;
import com.alurapractice.challengebooksearch.service.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class Principal {
    Scanner teclado = new Scanner(System.in);
    APIConsumer apiConsumer = new APIConsumer();
    DataConverter dataConverter = new DataConverter();
    private BookService bookService;
    private AuthorService authorService;
    private final String URL_BASE = "https://gutendex.com/books/";

    public Principal(IBookRepository bookRepository, IAutorRepository autorRepository) {
        this.bookService = new BookService(bookRepository);
        this.authorService = new AuthorService(autorRepository);
    }

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
                    List<Book> books = bookService.getAll();
                    books.forEach(System.out::println);
                    break;
                case 3:
                    List<Autor> author = authorService.getAuthors();
                    author.forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Ingresa el año");
                    Integer comparationYear = Integer.valueOf(teclado.nextLine());
                    List<Autor> author1 = authorService.getAliveAuthorsByYear(comparationYear);
                    author1.forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Ingresa el idioma de los libros que quieres buscar: ");
                    String language = teclado.nextLine();
                    List<Book> books1 = bookService.getBookByLanguage(language);
                    books1.forEach(System.out::println);
                    break;
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
            Long authorId = authorService.saveAuthor(bookInfo.get().author().get(0));
            bookService.saveBook(bookInfo.get(), authorId);
            System.out.println("------ Libro ----");
            System.out.println("Autor: " + bookInfo.get().author().get(0).name());
            System.out.println("Idioma: " + bookInfo.get().lenguage().get(0));
            System.out.println("Numero de descargas: " + bookInfo.get().downloads());
            System.out.println("------------------");
        }else {
            System.out.println("Libro no encontrado");
        }
    }





}
