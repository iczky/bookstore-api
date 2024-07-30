package com.bookstore.demo.books.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "book", schema = "public")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String publisher;

    private String isbn;
}
