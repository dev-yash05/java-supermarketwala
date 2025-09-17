package com.example.supermarketwala.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.supermarketwala.model.Category;

@Service
public class CategoryServiceImplementation implements CategoryService {
	
	List<Category> categories = new ArrayList<>();

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public String addCategory(Category category) {
		categories.add(category);
		return category.toString() +" Added Successfully!";
	}

	@Override
	public String deleteCategory(int categoryId) {
		categoryId--;
		categories.remove(categoryId);
		return  categories.get(categoryId).toString() + " Deleted Successfully!" ;
	}

	@Override
	public String updateCategory(int categoryId, Category category) {
		categoryId--;
		categories.set(categoryId, category);
		return "Category with Id:" + categories.get(categoryId).getCategoryId() + " Updated to " + category.toString() + " Successfully!";
	}
	
	
}
