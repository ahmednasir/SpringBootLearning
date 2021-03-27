package org.example.SpringBoot1.repository;

import org.example.SpringBoot1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);

}
