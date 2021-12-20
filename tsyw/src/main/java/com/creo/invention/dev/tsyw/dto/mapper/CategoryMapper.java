package com.creo.invention.dev.tsyw.dto.mapper;

import com.creo.invention.dev.tsyw.dto.category.CategoryDto;
import com.creo.invention.dev.tsyw.dto.category.CreateCategoryDto;
import com.creo.invention.dev.tsyw.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toDto(Category category);

    List<CategoryDto> toDtoList(List<Category> categoryList);

    Category fromCreateDto(CreateCategoryDto categoryDto);

    Category fromDro(CategoryDto categoryDto);
}
