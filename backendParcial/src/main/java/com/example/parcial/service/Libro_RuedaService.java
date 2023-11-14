
package com.example.parcial.service;


import com.example.parcial.Dtos.BibliotecaDTO;
import com.example.parcial.Modelo.Biblioteca_Rueda;
import com.example.parcial.Modelo.Libro_Rueda;
import com.example.parcial.repositories.Libro_RuedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Libro_RuedaService implements Libro_RuedaRepository {
    @Autowired
    Libro_RuedaRepository libroRuedaRepository;

    @Override
    public <S extends Libro_Rueda> S save(S entity) {
        return libroRuedaRepository.save(entity);
    }

    @Override
    public <S extends Libro_Rueda> Iterable<S> saveAll(Iterable<S> entities) {
        return libroRuedaRepository.saveAll(entities);
    }

    @Override
    public Optional<Libro_Rueda> findById(Long id) {
        return libroRuedaRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return libroRuedaRepository.existsById(id);
    }

    @Override
    public Iterable<Libro_Rueda> findAll() {
        return libroRuedaRepository.findAll();
    }

    @Override
    public Iterable<Libro_Rueda> findAllById(Iterable<Long> longs) {
        return libroRuedaRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return libroRuedaRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        libroRuedaRepository.deleteById(id);
    }

    @Override
    public void delete(Libro_Rueda entity) {
        libroRuedaRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        libroRuedaRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Libro_Rueda> entities) {
        libroRuedaRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        libroRuedaRepository.deleteAll();
    }

    public BibliotecaDTO convertirBibliotecaABibliotecaDTO(Biblioteca_Rueda biblioteca) {
        BibliotecaDTO bibliotecaDTO = new BibliotecaDTO();
        bibliotecaDTO.setId(biblioteca.getId());
        bibliotecaDTO.setNombre(biblioteca.getNombre());
        bibliotecaDTO.setDireccion(biblioteca.getDireccion());
        bibliotecaDTO.setCiudad(biblioteca.getCiudad());
        return bibliotecaDTO;
    }

    public Biblioteca_Rueda convertirBibliotecaDTOABiblioteca(BibliotecaDTO bibliiotecaDTO) {
        Biblioteca_Rueda biblioteca = new Biblioteca_Rueda();
        biblioteca.setId(bibliiotecaDTO.getId());
        biblioteca.setNombre(bibliiotecaDTO.getNombre());
        biblioteca.setDireccion(bibliiotecaDTO.getDireccion());
        biblioteca.setCiudad(bibliiotecaDTO.getCiudad());
        return biblioteca;
    }



}

