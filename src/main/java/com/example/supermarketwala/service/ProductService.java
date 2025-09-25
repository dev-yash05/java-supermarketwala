package com.example.supermarketwala.service;

import java.util.List;

import com.example.supermarketwala.model.Product;

public interface ProductService {
	
	//Get Categories
	public List<Product> getProducts();
	
	//Add Categories
	public String addProduct(Product product);
	
	//Delete a Category
	public String deleteProduct(int productId);
	
	//Update a Category
	public String updateProduct(int productId, Product product);


}
