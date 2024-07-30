package com.bookstore.demo.books.service;

import com.bookstore.demo.books.dto.CreateBookRequestDto;
import com.bookstore.demo.books.entity.Book;

import java.util.List;

public interface BookService {
    Book getBook(Long id);
    List<Book> getAllBooks();
    void saveBook(CreateBookRequestDto dto);
    void deleteBook(Long id);
    Book updateBook(Long id, Book book);
}
