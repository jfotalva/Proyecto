package com.example.library.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/library")
public class LibraryController {

    public LibraryController() {
    }

    @GetMapping("/books")
    public String listBooks() {
        return "Obtener todos los libros";
    }

    @GetMapping("/books/{id}")
    public String findBook(@PathVariable String id) {
        return "Obtener solo un libro con ID: " + id;
    }

    // http://localhost:7000/library/books?author=Gabriel García Márquez_NK
    // http://localhost:7000/library/books/author?author=Gabriel García Márquez_OK
    @GetMapping("/books/author")
    public String findAuthor(@RequestParam(value = "author") String author) {
        return "Obtener un autor con el parámetro: " + author;
    }

    @PostMapping("/books")
    public String addBook() {
        return "Agregar un libro ....";
    }

    @PutMapping("/books/{id}")
    public String updateBook(@PathVariable String id) {
        return "Actualizo libro con ID: " + id;
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable String id) {
        return "Elimino libro con ID: " + id;
    }

}
