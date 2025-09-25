package com.example.supermarketwala.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.supermarketwala.model.Product;

@Service
public class ProductServiceImplementation implements ProductService {

	List<Product> products = new ArrayList<>();

	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public String addProduct(Product product) {
		products.add(product);
		return product.toString() +" Added Successfully!";
	}

	@Override
	public String deleteProduct(int productId) {
		productId--;
		products.remove(productId);
		return products.get(productId).toString() + " Deleted Successfully!";
	}

	@Override
	public String updateProduct(int productId, Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
