package com.bookstore.demo.books.dto;

import lombok.Data;

@Data
public class CreateBookRequestDto {
    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private Long categoryId;
}
