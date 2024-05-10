package com.varundev.blog.controllers;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.varundev.blog.payloads.*;
import com.varundev.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryservice; 
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categortDto){
		CategoryDto createcategory= this.categoryservice.createCategory(categortDto);
		return new ResponseEntity<CategoryDto>(createcategory,HttpStatus.CREATED);
		
	}
	
	
	//update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categortDto, @PathVariable Integer categoryId){
		CategoryDto updatecategory= this.categoryservice.updateCategory(categortDto,categoryId);
		return new ResponseEntity<CategoryDto>(updatecategory,HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping("/{categoryId}")
	 public ResponseEntity<?> deleteCategory(@PathVariable Integer categoryId){
  	  this.categoryservice.deleteCategory(categoryId);
  	  return new ResponseEntity<>(Map.of("message","Category Deleted Successfully."), HttpStatus.OK);
    }
	
	//get
	 @GetMapping("/{categoryId}")
	 public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable Integer categoryId ){
   	  return ResponseEntity.ok(this.categoryservice.getCategory(categoryId));
   	  
     }
	
	//getAll
	 @GetMapping("/")
     public ResponseEntity<List<CategoryDto>> getAllCategories(){
   	  return ResponseEntity.ok(this.categoryservice.getCategories());
     }
     
}
