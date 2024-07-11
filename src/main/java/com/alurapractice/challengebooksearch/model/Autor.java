package com.alurapractice.challengebooksearch.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date dateOfBorn;
    private Date dateOfDeath;
    @OneToMany(mappedBy = "autorId")
    private Set<Book> book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBorn() {
        return dateOfBorn;
    }

    public void setDateOfBorn(Date dateOfBorn) {
        this.dateOfBorn = dateOfBorn;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }
}
