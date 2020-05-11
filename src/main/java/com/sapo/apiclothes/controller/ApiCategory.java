package com.sapo.apiclothes.controller;

import com.sapo.apiclothes.model.Category;
import com.sapo.apiclothes.model.Products;
import com.sapo.apiclothes.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/category")
public class ApiCategory {
    @Autowired
    CategoryRepository categoryRepository;
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategry(){
        List list=   categoryRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> getAllCategryBuId(@PathVariable("id") int id){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()== false){
            return new ResponseEntity("Not_ Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(category, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category categoryForm){
        Category category = categoryRepository.save(categoryForm);
        return new ResponseEntity(category, HttpStatus.OK);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable("id") int id,@RequestBody Category categoryForm){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()== false){
            return new ResponseEntity("Not_ Found",HttpStatus.NOT_FOUND);
        }
        else{
            category.get().setName(categoryForm.getName());
            categoryRepository.save(category.get());
            return new ResponseEntity("Success!!", HttpStatus.OK);
        }

    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") int id){
        Optional<Category> category = categoryRepository.findById(id);
        if (category == null) {
            return new ResponseEntity("Not_Foubd",HttpStatus.NOT_FOUND);
        } else {
            categoryRepository.delete(category.get());
            return new ResponseEntity("Success!!", HttpStatus.OK);
        }
    }
}
