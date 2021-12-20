package com.creo.invention.dev.tsyw.controller;

import com.creo.invention.dev.tsyw.dto.category.CategoryDto;
import com.creo.invention.dev.tsyw.dto.category.CreateCategoryDto;
import com.creo.invention.dev.tsyw.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public CategoryDto addNewCategory(@RequestBody CreateCategoryDto createCategoryDto) {
        return categoryService.addNewCategory(createCategoryDto);
    }

    @PutMapping
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(categoryDto);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategoryById(@PathVariable UUID categoryId) {
        categoryService.deleteCategoryById(categoryId);
    }
}
