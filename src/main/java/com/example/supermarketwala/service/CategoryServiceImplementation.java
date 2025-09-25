package com.example.supermarketwala.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.supermarketwala.exception.NotFoundException;
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
		Long id = Long.valueOf(categoryId);
		Category categoryToBeRemoved = findByIdOrThrow(id);
		categories.remove(categoryToBeRemoved);
		return  categoryToBeRemoved.toString() + " Deleted Successfully!" ;
	}

	@Override
	public String updateCategory(int categoryId, Category category) {
		categoryId--;
		categories.set(categoryId, category);
		return "Category with Id:" + categories.get(categoryId).getCategoryId() + " Updated to " + category.toString() + " Successfully!";
	}

	@Override
	public Category getCategory(int categoryId) {
//		categoryId--;
//		boolean found = false;
//		Long foundId = 0L;
//		
//		for(int i =0; i <= categoryId; i++) {
//			foundId = categories.get(i).getCategoryId();
//			
//		}
//		
//		
////		Category category = categories.get(categoryId);
		
		return null;
	}
	
	
	private Category findByIdOrThrow(Long id) {
		Optional<Category> opt = categories.stream()
				.filter(c -> c.getCategoryId() != null && c.getCategoryId().equals(id))
				.findFirst();
		return opt.orElseThrow(() -> new NotFoundException("Category with Id: " + id + " Not found!"));
	}
	
}
