
package com.example.parcial.service;


import com.example.parcial.Dtos.BibliotecaDTO;
import com.example.parcial.Modelo.Biblioteca_Rueda;
import com.example.parcial.repositories.Biblioteca_RuedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Bibliioteca_RuedaService  {
    @Autowired
    Biblioteca_RuedaRepository bibliotecaRuedaRepository;


    public BibliotecaDTO guardarBiblioteca(BibliotecaDTO bibliotecaDTO) {
        Biblioteca_Rueda biblioteca = convertirBibliotecaDTOABiblioteca(bibliotecaDTO);
        return convertirBibliotecaABibliotecaDTO(bibliotecaRuedaRepository.save(biblioteca));
    }

    public Iterable<BibliotecaDTO> guardarTodasBibliotecas(Iterable<BibliotecaDTO> bibliotecasDTO) {
        List<Biblioteca_Rueda> bibliotecas = new ArrayList<>();
        bibliotecasDTO.forEach(bibliotecaDTO -> bibliotecas.add(convertirBibliotecaDTOABiblioteca(bibliotecaDTO)));
        Iterable<Biblioteca_Rueda> savedBibliotecas = bibliotecaRuedaRepository.saveAll(bibliotecas);

        List<BibliotecaDTO> savedBibliotecasDTO = new ArrayList<>();
        savedBibliotecas.forEach(biblioteca -> savedBibliotecasDTO.add(convertirBibliotecaABibliotecaDTO(biblioteca)));

        return savedBibliotecasDTO;
    }

    public BibliotecaDTO encontrarBibliotecaPorId(Long id) {
        return bibliotecaRuedaRepository.findById(id)
                .map(this::convertirBibliotecaABibliotecaDTO)
                .orElse(null);
    }

    public boolean existeBibliotecaPorId(Long id) {
        return bibliotecaRuedaRepository.existsById(id);
    }

    public Iterable<BibliotecaDTO> listarTodasBibliotecas() {
        List<BibliotecaDTO> bibliotecasDTO = new ArrayList<>();
        bibliotecaRuedaRepository.findAll().forEach(biblioteca -> bibliotecasDTO.add(convertirBibliotecaABibliotecaDTO(biblioteca)));
        return bibliotecasDTO;
    }

    public long contarBibliotecas() {
        return bibliotecaRuedaRepository.count();
    }

    public void eliminarBibliotecaPorId(Long id) {
        bibliotecaRuedaRepository.deleteById(id);
    }

    public void eliminarBiblioteca(BibliotecaDTO bibliotecaDTO) {
        Biblioteca_Rueda biblioteca = convertirBibliotecaDTOABiblioteca(bibliotecaDTO);
        bibliotecaRuedaRepository.delete(biblioteca);
    }

    public void eliminarTodasBibliotecasPorId(Iterable<Long> ids) {
        bibliotecaRuedaRepository.deleteAllById(ids);
    }

    public void eliminarTodasBibliotecas(Iterable<BibliotecaDTO> bibliotecasDTO) {
        List<Biblioteca_Rueda> bibliotecas = new ArrayList<>();
        bibliotecasDTO.forEach(bibliotecaDTO -> bibliotecas.add(convertirBibliotecaDTOABiblioteca(bibliotecaDTO)));
        bibliotecaRuedaRepository.deleteAll(bibliotecas);
    }

    public void eliminarTodasBibliotecas() {
        bibliotecaRuedaRepository.deleteAll();
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

