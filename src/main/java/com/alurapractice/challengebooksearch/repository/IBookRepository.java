package com.alurapractice.challengebooksearch.repository;

import com.alurapractice.challengebooksearch.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
