package com.bookstore.demo.books.service.Impl;

import com.bookstore.demo.books.dto.CreateBookRequestDto;
import com.bookstore.demo.books.entity.Book;
import com.bookstore.demo.books.repository.BookRepository;
import com.bookstore.demo.books.service.BookService;
import com.bookstore.demo.category.entity.Category;
import com.bookstore.demo.category.service.CategoryService;
import com.bookstore.demo.exceptions.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
    }

    @Override
    public Book getBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            throw new DataNotFoundException("Book not found");
        }
        return book.get();
//        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(CreateBookRequestDto dto) {
        Category category = categoryService.findCategoryById(dto.getCategoryId());

        Book book = new Book();
        book.setAuthor(dto.getAuthor());
        book.setTitle(dto.getTitle());
        book.setPublisher(dto.getPublisher());
        book.setIsbn(dto.getIsbn());
        book.setCategory(category);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        if (bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        } else {
            throw new DataNotFoundException("Book is not there");
        }
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book book1 = bookRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Book not found"));
        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        book1.setPublisher(book.getPublisher());
        return bookRepository.save(book1);
    }
}
