package com.example.supermarketwala.service;

import java.util.List;

import com.example.supermarketwala.model.Category;

public interface CategoryService {
	
	//Get Categories
	public List<Category> getCategories();
	
	public Category getCategory(int categoryId); 
	
	//Add Categories
	public String addCategory(Category category);
	
	//Delete a Category
	public String deleteCategory(int categoryId);
	
	//Update a Category
	public String updateCategory(int categoryId, Category category);

}