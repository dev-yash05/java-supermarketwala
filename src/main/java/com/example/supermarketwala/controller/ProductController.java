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

import com.example.supermarketwala.model.Product;

@RestController
@RequestMapping("api/v1")
public class ProductController {

	List<Product> products = new ArrayList<>();
	
	@GetMapping("/products")
	List<Product> getProducts(){
		return products;
	}
	
	@PostMapping("/products")
	String addProduct(@RequestBody Product product){
		products.add(product);
		return "Product Added Successfully!";
	}
	
	@DeleteMapping("/products/d/{productId}")
	String deleteProduct(@PathVariable("productId") int productId) {
		productId--;
		products.remove(productId);
		return"Product Deleted Successfully!";
	}
	
	@PutMapping("/products/u/{productId}")
	String updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
		productId--;
		products.set(productId, product);
		return "Product Updated Successfully!";
	}
	
}
