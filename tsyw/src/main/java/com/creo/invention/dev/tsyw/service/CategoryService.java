package com.creo.invention.dev.tsyw.service;

import com.creo.invention.dev.tsyw.dto.category.CategoryDto;
import com.creo.invention.dev.tsyw.dto.category.CreateCategoryDto;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    CategoryDto addNewCategory(CreateCategoryDto createCategoryDto);

    void deleteCategoryById(UUID categoryId);

    CategoryDto updateCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategories();
}
