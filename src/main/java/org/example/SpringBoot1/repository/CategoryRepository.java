package org.example.SpringBoot1.repository;

import org.example.SpringBoot1.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
