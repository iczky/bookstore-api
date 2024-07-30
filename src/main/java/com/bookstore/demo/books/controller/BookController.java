package com.bookstore.demo.books.controller;

import com.bookstore.demo.books.dto.CreateBookRequestDto;
import com.bookstore.demo.books.entity.Book;
import com.bookstore.demo.books.service.BookService;
import com.bookstore.demo.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        return Response.successResponse("Get All Books", bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        return Response.successResponse("get book by id", bookService.getBook(id));
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody CreateBookRequestDto dto) {
        bookService.saveBook(dto);
        return Response.successResponse("add book");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return Response.successResponse("delete book");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return Response.successResponse("update book", bookService.updateBook(id, book));
    }
}
