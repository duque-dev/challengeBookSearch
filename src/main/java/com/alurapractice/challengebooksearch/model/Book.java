package com.alurapractice.challengebooksearch.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="libro")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lenguage;
    private int downloads;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLenguage() {
        return lenguage;
    }

    public void setLenguage(String lenguage) {
        this.lenguage = lenguage;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", lenguage='" + lenguage + '\'' +
                ", downloads=" + downloads;
    }
}
