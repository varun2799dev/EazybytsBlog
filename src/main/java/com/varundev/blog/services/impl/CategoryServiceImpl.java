package com.varundev.blog.services.impl;
import java.util.List;
import java.util.stream.Collectors;

import com.varundev.blog.entities.Category;
import com.varundev.blog.exceptions.ResourceNotFoundException;
import com.varundev.blog.payloads.CategoryDto;
import com.varundev.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.*;
import com.varundev.blog.repositories.CategoryRepo;
public class CategoryServiceImpl implements CategoryService {
    
	@Autowired
	private CategoryRepo categoryRepo;
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category cat = this.dtotoCategory(categoryDto);
		Category addedCat = this.categoryRepo.save(cat);
		
		return this.categoryToDto(addedCat);
		
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Id",categoryId));
		
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCat = this.categoryRepo.save(category);
		CategoryDto categoryDto1= this.categoryToDto(updatedCat);
		
		return categoryDto1;
		
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Id",categoryId));
		this.categoryRepo.delete(category);

	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Id",categoryId));
		return this.categoryToDto(category);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories = this.categoryRepo.findAll();
		List <CategoryDto> categoryDtos = categories.stream().map(category ->this.categoryToDto(category)).collect(Collectors.toList());
		return categoryDtos;
	}

	private Category dtotoCategory(CategoryDto categoryDto) {
		
		Category category= new Category();
		category.setCategoryId(categoryDto.getCategoryId());
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		return category;
	}
	public CategoryDto categoryToDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryId(category.getCategoryId());
		categoryDto.setCategoryTitle(category.getCategoryTitle());
		categoryDto.setCategoryDescription(category.getCategoryDescription());
		
		return categoryDto;
	}
}
