package com.example.library.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.library.model.Book;

@Repository
public class MemoryBookRepository implements BookRepository {
    private Map<String, Book> bookMap;

    public MemoryBookRepository() {
        bookMap = new HashMap<>();
    }

    @Override
    public List<Book> getAll() {
        List<Book> book = new ArrayList<>();
        book.addAll(bookMap.values());
        return book;
    }

    @Override
    public Book get(String bookId) {
        return bookMap.get(bookId);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookMap.values().stream()
                .filter(book -> book.getAuthor().toLowerCase().indexOf(author.toLowerCase()) >= 0)
                .collect(Collectors.toList());
    }

    @Override
    public Book save(Book book) {
        if (book.getBookId() == null) {
            book.setBookId(String.valueOf(System.currentTimeMillis()));
        }
        bookMap.put(book.getBookId(), book);
        return book;
    }

    @Override
    public Book delete(String bookId) {
        return bookMap.remove(bookId);
    }

}
