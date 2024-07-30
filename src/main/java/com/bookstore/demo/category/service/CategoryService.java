package com.bookstore.demo.category.service;

import com.bookstore.demo.category.dto.CreateCategoryRequestDto;
import com.bookstore.demo.category.entity.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(CreateCategoryRequestDto dto);
    List<Category> findAllCategory();
    void deleteCategory(Long id);
    Category findCategoryById(Long id);
}
