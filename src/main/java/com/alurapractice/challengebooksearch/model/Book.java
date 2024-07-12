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
    private List<String> lenguage;
    private Double downloads;
    private Long autorId;



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

    public List<String> getLenguage() {
        return lenguage;
    }

    public void setLenguage(List<String> lenguage) {
        this.lenguage = lenguage;
    }

    public Double getDownloads() {
        return downloads;
    }

    public void setDownloads(Double downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + bookName + '\'' +
//                ", author=" + author +
                ", lenguage='" + lenguage + '\'' +
                ", downloads=" + downloads +
                ", autorId=" + autorId;
    }
}
