package com.bookstore.demo.category.entity;

import com.bookstore.demo.books.entity.Book;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "category", schema = "public")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "book")
    private Book book;
}
