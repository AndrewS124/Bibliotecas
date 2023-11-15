package com.example.parcial.rest;


import com.example.parcial.Dtos.BibliotecaDTO;
import com.example.parcial.Modelo.Biblioteca_Rueda;
import com.example.parcial.service.Bibliioteca_RuedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Biblioteca/")
public class Biblioteca_RuedaRest {

    @Autowired
    private Bibliioteca_RuedaService bibliiotecaRuedaService;

    @PostMapping
    public ResponseEntity<BibliotecaDTO> createBiblioteca(@RequestBody BibliotecaDTO bibliotecaDTO) {
        BibliotecaDTO nuevaBibliotecaDTO = bibliiotecaRuedaService.guardarBiblioteca(bibliotecaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaBibliotecaDTO);
    }

    @GetMapping
    public ResponseEntity<List<BibliotecaDTO>> getAllBibliotecas() {
        Iterable<BibliotecaDTO> bibliotecasDTO = bibliiotecaRuedaService.listarTodasBibliotecas();
        List<BibliotecaDTO> bibliotecasDTOList = new ArrayList<>();
        bibliotecasDTO.forEach(bibliotecasDTOList::add);
        return ResponseEntity.ok(bibliotecasDTOList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BibliotecaDTO> updateBiblioteca(@PathVariable Long id, @RequestBody BibliotecaDTO bibliotecaDTO) {
        if (!bibliiotecaRuedaService.existeBibliotecaPorId(id)) {
            return ResponseEntity.notFound().build();
        }

        bibliotecaDTO.setId(id);
        BibliotecaDTO bibliotecaActualizadaDTO = bibliiotecaRuedaService.guardarBiblioteca(bibliotecaDTO);
        return ResponseEntity.ok(bibliotecaActualizadaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBiblioteca(@PathVariable Long id) {
        if (!bibliiotecaRuedaService.existeBibliotecaPorId(id)) {
            return ResponseEntity.notFound().build();
        }

        bibliiotecaRuedaService.eliminarBibliotecaPorId(id);
        return ResponseEntity.noContent().build();
    }

}
