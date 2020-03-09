package com.sapo.apiclothes.service;

import com.sapo.apiclothes.model.Category;
import com.sapo.apiclothes.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public ResponseEntity<List<Category>> getAllCategory(){
     List list=   categoryRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    public ResponseEntity<Category> getAllCategory(int id){
        Category category =   categoryRepository.getOne(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    public ResponseEntity<String> addCategory(@RequestBody Category categoryForm){
        categoryRepository.save(categoryForm);
        return new ResponseEntity("Success", HttpStatus.OK);
    }
    public ResponseEntity<String> updateCategory(int id,@RequestBody Category categoryForm){
        Category category = categoryRepository.getOne(id);
        category.setName(categoryForm.getName());
        categoryRepository.save(category);
        return new ResponseEntity("Success", HttpStatus.OK);
    }
    public ResponseEntity<String> deleteCategory(int id){
        Category category = categoryRepository.getOne(id);
        categoryRepository.delete(category);
        return new ResponseEntity("Success", HttpStatus.OK);
    }

}
