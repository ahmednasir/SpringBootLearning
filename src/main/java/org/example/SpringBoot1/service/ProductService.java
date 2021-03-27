package org.example.SpringBoot1.service;

import java.util.List;

import org.example.SpringBoot1.entity.Product;
import org.example.SpringBoot1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> saveAllProduct(List<Product> products) {
		return repository.saveAll(products);
	}

	public List<Product> getAllProduct() {
		return repository.findAll();
	}

	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}

	public Product getProductByName(String name) {
		return repository.findByName(name);
	}

	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "Success";
	}

	public Product updateProduct(Product product) {
		try {

			Product existingProduct = repository.findById(product.getId()).orElse(null);
			if (existingProduct == null) {
				throw new NullPointerException();
			}
			existingProduct.setName(product.getName());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setQuantity(product.getQuantity());
			return repository.save(existingProduct);

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
