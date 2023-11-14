package com.example.parcial.Dtos;

import com.example.parcial.Modelo.Biblioteca_Rueda;

import javax.persistence.OneToOne;

public class LibroDTO{

    private Long id;

    private String nombre;

    private String autor;

    private Biblioteca_Rueda biblioteca;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Biblioteca_Rueda getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca_Rueda biblioteca) {
        this.biblioteca = biblioteca;
    }
}
