package com.example.supermarketwala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supermarketwala.model.Category;
import com.example.supermarketwala.service.CategoryService;

@RestController
@RequestMapping("api/v1")
public class CategoryController {

	//Dependency Injection
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	List<Category> getCategories() {
		
		return categoryService.getCategories();
	}
	
	@PostMapping("/categories")
	String addCategory(@RequestBody Category category) {
		String message = categoryService.addCategory(category);
		return message;
	}
	
	@DeleteMapping("/categories/d/{catId}")
	String deleteCategory(@PathVariable("catId") int categoryId) {
		String message = categoryService.deleteCategory(categoryId);
		return message;
	}
	
	@PutMapping("/categories/u/{catId}")
	String updateCategory(@PathVariable("catId") int categoryId,@RequestBody Category category) {
		String message = categoryService.updateCategory(categoryId, category);
		return message;
	}
	
}
