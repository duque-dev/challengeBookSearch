package com.alurapractice.challengebooksearch.repository;

import com.alurapractice.challengebooksearch.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAutorRepository extends JpaRepository<Autor, Long> {
}
