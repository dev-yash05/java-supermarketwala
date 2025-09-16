package com.example.supermarketwala.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supermarketwala.model.Category;

@RestController
@RequestMapping("api/v1")
public class CategoryController {

	List<Category> categories = new ArrayList<>();
	
	@GetMapping("/categories")
	List<Category> getCategories() {
		return categories;
	}
	
	@PostMapping("/categories")
	String addCategory(@RequestBody Category category) {
		categories.add(category);
		return "Category " + category.getCategoryName() +" Added Successfully!";
	}
	
	@DeleteMapping("/categories/d/{catId}")
	String deleteCategory(@PathVariable("catId") int categoryId) {
		categoryId--;
		categories.remove(categoryId);
		return "Category Deleted Successfully";
	}
	
	@PutMapping("/categories/u/{catId}")
	String updateCategory(@PathVariable("catId") int categoryId,@RequestBody Category category) {
		categoryId--;
		categories.set(categoryId, category);
		return "Category updated successfully";
	}
	
}
