package com.example.supermarketwala.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supermarketwala.exception.NotFoundException;
import com.example.supermarketwala.model.Category;
import com.example.supermarketwala.repo.CategoryRepository;

@Service
public class CategoryServiceImplementation implements CategoryService {
	

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}
	
	@Override
	public Category getCategory(Long categoryId) {

	    return categoryRepository.findById(categoryId)
	            .orElseThrow(() -> new NotFoundException("Category with Id: " + categoryId + " not found!"));
	}

	@Override
	public String addCategory(Category category) {
		categoryRepository.save(category);
		return category.toString() +" Added Successfully!";
	}

	@Override
	public String deleteCategory(Long categoryId) {
		Optional<Category> categoryToBeDeleted = categoryRepository.findById(categoryId);
		categoryRepository.deleteById(categoryId);
		return categoryToBeDeleted.toString() +" Deleted Successfully!" ;
	}

	@Override
	public String updateCategory(Long categoryId, Category category) {

	    // Find existing category or throw exception
	    Category existingCategory = categoryRepository.findById(categoryId)
	            .orElseThrow(() -> new NotFoundException("Category with Id " + categoryId + " not found!"));

	    // Update fields (only the ones you want to allow updating)
	    existingCategory.setCategoryName(category.getCategoryName());
	    // add more setters if your Category has more fields

	    // Save updated entity
	    categoryRepository.save(existingCategory);

	    return "Category with Id: " + categoryId + " updated to " + existingCategory.toString() + " successfully!";
	}

	
	
//	private Category findByIdOrThrow(Long id) {
//		Optional<Category> opt = categories.stream()
//				.filter(c -> c.getCategoryId() != null && c.getCategoryId().equals(id))
//				.findFirst();
//		return opt.orElseThrow(() -> new NotFoundException("Category with Id: " + id + " Not found!"));
//	}
	
}
