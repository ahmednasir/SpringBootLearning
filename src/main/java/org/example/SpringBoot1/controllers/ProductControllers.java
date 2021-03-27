package org.example.SpringBoot1.controllers;

import java.util.List;

import org.example.SpringBoot1.entity.Product;
import org.example.SpringBoot1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControllers {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/product")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/product/multiple")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return productService.saveAllProduct(products);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/product")
	public List<Product> getAllProducts() {
		return productService.getAllProduct();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/product/{id}")
	public Product getProductsById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/product/name/{name}")
	public Product getProductsByName(@PathVariable String name) {
		return productService.getProductByName(name);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/product/{id}")
	public String deleProduct(@PathVariable int id) {
		return productService.deleteProduct(id);
	}
	
}
