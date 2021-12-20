package com.creo.invention.dev.tsyw.service.impl;

import com.creo.invention.dev.tsyw.dto.category.CategoryDto;
import com.creo.invention.dev.tsyw.dto.category.CreateCategoryDto;
import com.creo.invention.dev.tsyw.dto.mapper.CategoryMapper;
import com.creo.invention.dev.tsyw.exception.NotFoundException;
import com.creo.invention.dev.tsyw.model.Category;
import com.creo.invention.dev.tsyw.repository.CategoryRepository;
import com.creo.invention.dev.tsyw.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDto addNewCategory(CreateCategoryDto createCategoryDto) {
        Category category = categoryMapper.fromCreateDto(createCategoryDto);
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public void deleteCategoryById(UUID categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        UUID categoryId = categoryDto.getCategoryId();
        if (!categoryRepository.existsById(categoryId)) {
            throw new NotFoundException(String.format("Category with id %s not found", categoryId));
        }
        Category category = categoryMapper.fromDro(categoryDto);
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryMapper.toDtoList(categoryRepository.findAll());
    }
}
