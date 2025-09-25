package com.example.supermarketwala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	ResponseEntity<List<Category>> getCategories() {
		List<Category> categories = categoryService.getCategories();
		return ResponseEntity.ok().body(categories);
	}
	
	//return a single category based on the categoryId to the user
	@GetMapping("/category/{catId}")
	ResponseEntity<Category> getCategory(@PathVariable("catId") int categoryId){
		
		Category category = categoryService.getCategory(categoryId);
		return ResponseEntity.ok().body(category);
	}
		
	@PostMapping("/categories")
	ResponseEntity<String> addCategory(@RequestBody Category category) {
		String message = categoryService.addCategory(category);
		return ResponseEntity.accepted().body(message);
	}
	
	@DeleteMapping("/categories/d/{catId}")
	ResponseEntity<String> deleteCategory(@PathVariable("catId") int categoryId) {
		String message = categoryService.deleteCategory(categoryId);
		return ResponseEntity.ok().body(message);
	}
	
	@PutMapping("/categories/u/{catId}")
	ResponseEntity<String> updateCategory(@PathVariable("catId") int categoryId,@RequestBody Category category) {
		String message = categoryService.updateCategory(categoryId, category);
		return ResponseEntity.ok().body(message);
	}
	
}
