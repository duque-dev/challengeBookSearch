package com.alurapractice.challengebooksearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="autor")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authorName;
    private String dateOfBorn;
    private String dateOfDeath;
    public Autor(){
    }

    public Autor(String authorName, String dateOfBorn, String dateOfDeath) {
        this.authorName = authorName;
        this.dateOfBorn = dateOfBorn;
        this.dateOfDeath = dateOfDeath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDateOfBorn() {
        return dateOfBorn;
    }

    public void setDateOfBorn(String dateOfBorn) {
        this.dateOfBorn = dateOfBorn;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    @Override
    public String toString() {
        return
                "Nombre Autor: '" + authorName + '\'' +
                ", Fecha Nacimiento:'" + dateOfBorn + '\'' +
                ", Fecha Fallecimiento: '" + dateOfDeath;
    }
}
