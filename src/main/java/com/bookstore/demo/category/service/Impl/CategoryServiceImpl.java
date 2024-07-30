package com.bookstore.demo.category.service.Impl;

import com.bookstore.demo.category.dto.CreateCategoryRequestDto;
import com.bookstore.demo.category.entity.Category;
import com.bookstore.demo.category.repository.CategoryRepository;
import com.bookstore.demo.category.service.CategoryService;
import com.bookstore.demo.exceptions.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(CreateCategoryRequestDto dto) {
        Category category = new Category();
        category.setName(dto.getName());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new DataNotFoundException("category not found"));
    }
}
