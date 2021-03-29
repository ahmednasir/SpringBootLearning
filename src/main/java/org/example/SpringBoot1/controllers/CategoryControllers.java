package org.example.SpringBoot1.controllers;

import org.example.SpringBoot1.entity.Category;
import org.example.SpringBoot1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryControllers {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, value = "/category")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategory();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/category")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/category/{id}")
    public void updateCategory(@RequestBody Category category, @PathVariable int id) {
        categoryService.updateCategory(category, id);
    }
}
