package com.example.library.util;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.library.model.Book;
import com.example.library.service.BookService;

@Component
public class DummyBookFilter {
    private final BookService bookservice;

    public DummyBookFilter(BookService bookservice) {
        this.bookservice = bookservice;
    }

    @PostConstruct
    public void initialize() {
        bookservice.saveBook(new Book(null, "La Biblia", "Primer libro de la historia", "Dios", 750000, 4));
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        bookservice.saveBook(new Book(null, "El Principito", "Es una eminencia de la literatura universal",
                "Antoine de Saint-Exupéry", 85000, 100));
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        bookservice.saveBook(new Book(null, "El extranjero",
                "Su temática te sumergirá en un viaje a través de la filosofía del absurdo", "Albert Camus", 138700,
                1));
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        bookservice.saveBook(
                new Book(null, "Un mundo feliz", "Un mundo feliz es tu lectura", "Aldoux Huxley", 24900, 320));
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        bookservice.saveBook(new Book(null, "Don Quijote de La Mancha",
                "Es un clásico de la literatura universal que tiene dos partes", "Miguel de Cervates", 330000, 5));
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
    }
}
