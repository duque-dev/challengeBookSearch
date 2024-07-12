package com.alurapractice.challengebooksearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="libro")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;
    private String language;
    private Double downloads;
    private Long autorId;

    public Book(){
    }

    public Book(String bookName, String language, Double downloads, Long autorId) {
        this.bookName = bookName;
        this.language = language;
        this.downloads = downloads;
        this.autorId = autorId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getDownloads() {
        return downloads;
    }

    public void setDownloads(Double downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        return
                ", Nombre Libro:'" + bookName + '\'' +
                ", Idioma: '" + language + '\'' +
                ", Descargas: " + downloads +
                ", AutorId=" + autorId;
    }
}
