package com.example.library.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    public Book get(String id) {
        return bookRepository.get(id);
    }

    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public Book saveBook(Book book) {
        book.setBookId(null);
        return bookRepository.save(book);
    }

    public Book updateBook(String bookId, Book book) {
        Book bookVar = bookRepository.get(bookId);
        if (bookVar == null) {
            return null;
        }
        book.setBookId(bookId);
        return bookRepository.save(book);
    }

    public Book delete(String id) {
        return bookRepository.delete(id);
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
