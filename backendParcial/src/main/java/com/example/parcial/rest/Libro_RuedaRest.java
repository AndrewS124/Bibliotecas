package com.example.parcial.rest;

import com.example.parcial.Modelo.Libro_Rueda;
import com.example.parcial.service.Libro_RuedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Libro/")
public class Libro_RuedaRest {

    @Autowired
    private Libro_RuedaService libroRuedaService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Libro_Rueda> createLibro(@RequestBody Libro_Rueda libroRueda) {
        Libro_Rueda nuevoLibro = libroRuedaService.save(libroRueda);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLibro);
    }

    @CrossOrigin
    @GetMapping
    private ResponseEntity<List<Libro_Rueda>> getAllLibros() {
        Iterable<Libro_Rueda> libros = libroRuedaService.findAll();
        List<Libro_Rueda> librosList = new ArrayList<>();

        libros.forEach(librosList::add);

        return ResponseEntity.ok(librosList);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Libro_Rueda> updateLibro(@PathVariable Long id, @RequestBody Libro_Rueda libro) {
        Optional<Libro_Rueda> libroExistente = libroRuedaService.findById(id);

        if (!libroExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        libro.setId(id);
        Libro_Rueda libroActualizado = libroRuedaService.save(libro);

        return ResponseEntity.ok(libroActualizado);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        Optional<Libro_Rueda> libroExistente = libroRuedaService.findById(id);

        if (!libroExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        libroRuedaService.delete(libroExistente.get());
        return ResponseEntity.noContent().build();
    }

}
