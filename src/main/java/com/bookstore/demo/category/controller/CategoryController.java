package com.bookstore.demo.category.controller;

import com.bookstore.demo.category.dto.CreateCategoryRequestDto;
import com.bookstore.demo.category.entity.Category;
import com.bookstore.demo.category.service.CategoryService;
import com.bookstore.demo.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        return Response.successResponse("Get all category", categoryService.findAllCategory());
    }

    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody CreateCategoryRequestDto dto) {
        return Response.successResponse("add category", categoryService.saveCategory(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return Response.successResponse("delete category", id);
    }
}
