package org.example.SpringBoot1.service;

import org.example.SpringBoot1.entity.Category;
import org.example.SpringBoot1.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void addCategory(Category category) {

        category.setCreatedOn(new Date());

        categoryRepository.save(category);
    }


    public void addMultipleCategory(List<Category> categories) {
        categoryRepository.saveAll(categories);
    }

    public String deleteCategory(int id) {
        categoryRepository.deleteById(id);
        return "Success";
    }

    public String updateCategory(Category category, int id) {
        try {
            Category existingCategory = categoryRepository.findById(id).orElse(null);
            if (category == null) {
                throw new NullPointerException();
            }
            existingCategory.setCategoryName(category.getCategoryName());
            existingCategory.setCreatedOn(new Date());
            categoryRepository.save(existingCategory);
            return "Success";
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
