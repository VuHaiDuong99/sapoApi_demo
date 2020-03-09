package com.sapo.apiclothes.controller;

import com.sapo.apiclothes.model.Category;
import com.sapo.apiclothes.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class ApiCategory {
    @Autowired
    CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategry(){
        return categoryService.getAllCategory();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> getAllCategryBuId(@PathVariable("id") int id){
        return categoryService.getAllCategory(id);
    }
    @PostMapping
    public ResponseEntity<String> addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable("id") int id,@RequestBody Category category){
        return categoryService.updateCategory(id,category);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") int id){
        return categoryService.deleteCategory(id);
    }

}
