package com.example.library.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.library.model.Book;
import com.example.library.repository.MemoryBookRepository;

@RestController
@RequestMapping(value = "/library")
public class LibraryController {

    Book book = new Book();
    MemoryBookRepository memoryBookRepository = new MemoryBookRepository();

    public LibraryController() {
    }

    @GetMapping("/books")
    public List<Book> getAll() {
        return memoryBookRepository.getAll();
    }

    @GetMapping("/books/{id}")
    public Book get(@PathVariable String id) {
        return memoryBookRepository.get(id);
    }

    // http://localhost:7000/library/books?author=Gabriel García Márquez_NK (Error,
    // método duplicado)
    // http://localhost:7000/library/books/author?author=Gabriel García Márquez_OK
    @GetMapping("/books/author")
    public List<Book> findByAuthor(@RequestParam(value = "author") String author) {
        return memoryBookRepository.findByAuthor(author);
    }

    @PostMapping("/books")
    public String saveBook(@RequestBody Book book) {
        memoryBookRepository.save(book);
        return "Se agregó el libro.";
    }

    @PutMapping("/books/{id}")
    public String updateBook(@RequestBody Book book) {
        Book bookVar = memoryBookRepository.get(book.getBookId());
        memoryBookRepository.save(book);
        return "Se actualizó el libro: \n" + "Antes:   " + bookVar + "\n" + "Después: " + book;
        //return book;
    }

    @DeleteMapping("/books/{id}")
    public String delete(@PathVariable String id) {
        memoryBookRepository.delete(id);
        return "Se eliminó el libro con Id: " + id;
    }
}
