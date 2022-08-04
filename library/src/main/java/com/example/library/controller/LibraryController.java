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
import com.example.library.service.BookService;

@RestController
@RequestMapping(value = "/library")
public class LibraryController {

    private final BookService bookService;

    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    // Obtengo todos los libros
    // Obtengo por nombre de Autor(Parámetro)
    // Obtengo por nombre de Libro(Parámetro)
    @GetMapping("/books")
    public List<Book> getAll(@RequestParam(required = false) String author, String title) {
        if ((author == null) && title == null) {
            return this.bookService.getAll();
        }
        if (author != null) {
            return this.bookService.findByAuthor(author);
        } else {
            return this.bookService.findByTitle(title);
        }
    }

    // Obtengo por bookId
    @GetMapping("/books/{bookId}")
    public Book get(@PathVariable String bookId) {
        return this.bookService.get(bookId);
    }

    // Guardo un nuevo libro
    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        return this.bookService.saveBook(book);
    }

    // Actualizo por bookId
    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable String bookId, @RequestBody Book book) {
        if (bookId.equals(book.getBookId())) {
            return this.bookService.updateBook(bookId, book);
        } else {
            return null;
        }
    }

    // Elimino por bookId
    @DeleteMapping("/books/{bookId}")
    public Book delete(@PathVariable String bookId) {
        return this.bookService.delete(bookId);
    }

}
