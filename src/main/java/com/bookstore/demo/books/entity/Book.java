package com.bookstore.demo.books.entity;

import com.bookstore.demo.category.entity.Category;
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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
}
