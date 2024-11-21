package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entity.Product;
import com.restapi.productrepo.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductControler {

	@Autowired
	ProductRepository repo;

	@GetMapping("/products")
	public List<Product> getProducts() {
		List<Product> products = repo.findAll();
		return products;
	}

	@GetMapping("/products/{di}")
	public Product getProduct(@PathVariable int di) {
		Product product = repo.findById(di).get();
		return product;
	}

	@PostMapping("/products")
	public void CreateProduct(@RequestBody Product product) {
		repo.save(product);
	}

	@PutMapping("/products/{di}")
	public Product UpdateProduct(@PathVariable int di) {
		Product product = repo.findById(di).get();
		product.setProduct_name("Wasing Machine");
		product.setProduct_price(38000);
		repo.save(product);
		return product;
	}

	@DeleteMapping("/products/{di}")
	public void DeleteProduct(@PathVariable int di) {
		Product product = repo.findById(di).get();
		repo.delete(product);
	}
}
