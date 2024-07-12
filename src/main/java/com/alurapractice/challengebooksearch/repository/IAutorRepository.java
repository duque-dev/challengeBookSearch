package com.alurapractice.challengebooksearch.repository;

import com.alurapractice.challengebooksearch.model.Autor;
import com.alurapractice.challengebooksearch.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT l FROM Autor l WHERE CAST(l.dateOfDeath as int) > :comparationYear AND CAST(l.dateOfBorn as int) < :comparationYear")
    List<Autor> getAliveAuthorsByYear(Integer comparationYear);
}
