package com.example.supermarketwala.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
}
