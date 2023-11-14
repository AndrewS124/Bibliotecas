package com.example.parcial.rest;


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

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Biblioteca_Rueda> createBiblioteca(@RequestBody Biblioteca_Rueda biblioteca) {
        Biblioteca_Rueda nuevaBiblio = bibliiotecaRuedaService.save(biblioteca);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaBiblio);
    }


    @CrossOrigin
    @GetMapping
    private ResponseEntity <List<Biblioteca_Rueda>> getAllBiliotecas() {
        Iterable<Biblioteca_Rueda> bibliotecas = bibliiotecaRuedaService.findAll();
        List<Biblioteca_Rueda> bibliotecasList = new ArrayList<>();

        bibliotecas.forEach(bibliotecasList::add);

        return ResponseEntity.ok(bibliotecasList);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Biblioteca_Rueda> updateBiblioteca(@PathVariable Long id, @RequestBody Biblioteca_Rueda biblio) {
        Optional<Biblioteca_Rueda> bibliotecaExistente = bibliiotecaRuedaService.findById(id);

        if (!bibliotecaExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        biblio.setId(id);
        Biblioteca_Rueda bibliotecaActualizada = bibliiotecaRuedaService.save(biblio);

        return ResponseEntity.ok(bibliotecaActualizada);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBilioteca(@PathVariable Long id) {
        Optional<Biblioteca_Rueda> bibliotecaExistente = bibliiotecaRuedaService.findById(id);

        if (bibliotecaExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        bibliiotecaRuedaService.(bibliotecaExistente.get());
        return ResponseEntity.noContent().build();
    }

}
