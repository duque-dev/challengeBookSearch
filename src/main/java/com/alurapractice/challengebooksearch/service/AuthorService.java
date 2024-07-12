package com.alurapractice.challengebooksearch.service;

import com.alurapractice.challengebooksearch.mapper.AutorDTO;
import com.alurapractice.challengebooksearch.model.Autor;
import com.alurapractice.challengebooksearch.repository.IAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorService {
    @Autowired
    private IAutorRepository autorRepository;

    public AuthorService(IAutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }
    public Long saveAuthor(AutorDTO autorDTO){
        Autor author = new Autor(autorDTO.name(),autorDTO.dateOfBorn(),autorDTO.dateOfDeath());
        autorRepository.save(author);
        return author.getId();
    }

    public List<Autor> getAuthors(){
       return autorRepository.findAll();
    }

    public List<Autor> getAliveAuthorsByYear(Integer comparationYear){
        return autorRepository.getAliveAuthorsByYear(comparationYear);
    }
}
