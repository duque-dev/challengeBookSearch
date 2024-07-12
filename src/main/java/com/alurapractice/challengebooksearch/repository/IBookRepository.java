package com.alurapractice.challengebooksearch.repository;

import com.alurapractice.challengebooksearch.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT l FROM Book l WHERE l.language = :language")
    List<Book> getBookByLanguage(String language);

}
