package com.alurapractice.challengebooksearch.service;

import com.alurapractice.challengebooksearch.mapper.AutorDTO;
import com.alurapractice.challengebooksearch.mapper.BookDTO;
import com.alurapractice.challengebooksearch.model.Book;
import com.alurapractice.challengebooksearch.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    public void saveBook(BookDTO bookDTO, Long authorId){
        Book book = new Book(bookDTO.name(),bookDTO.lenguage().get(0),bookDTO.downloads(),authorId);
        bookRepository.save(book);
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public List<Book> getBookByLanguage(String language){
        return bookRepository.getBookByLanguage(language);
    }


}
