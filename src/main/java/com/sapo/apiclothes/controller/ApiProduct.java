package com.sapo.apiclothes.controller;

import com.sapo.apiclothes.model.ProductDetail;
import com.sapo.apiclothes.model.Products;
import com.sapo.apiclothes.repository.Product_DetailRepository;
import com.sapo.apiclothes.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.*;

@RestController
@RequestMapping(value ="/api/product")
@CrossOrigin(origins = "*")
public class ApiProduct {
    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    Product_DetailRepository pdr;
    @GetMapping
    public ResponseEntity<List<Products>> getAllProduct(){
        List<Products> list = new ArrayList<Products>();
        list = productsRepository.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);

    }
    @PostMapping
    @Transactional
    public ResponseEntity<String>  addProduct(@RequestBody Products productAdd){
        Products products = new Products();
        if(productAdd.getName().isEmpty()){
            return new ResponseEntity<>("Name Null!!!",HttpStatus.NO_CONTENT);
        }
        if(productAdd.getImage().isEmpty()){
            return new ResponseEntity<>("Image Null!!!",HttpStatus.NO_CONTENT);
        }
        if(productAdd.getPrice().isEmpty()){
            return new ResponseEntity<>("Price Null!!!",HttpStatus.NO_CONTENT);
        }
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        productAdd.setCreateDate(date);
        productAdd.setUpdateDate(date);
        productsRepository.save(productAdd);
        return new ResponseEntity<>("Success",HttpStatus.OK);
}
    @GetMapping(value = "/{id}")
    public ResponseEntity<Products> getProductByID(@PathVariable("id") int id){
        Optional<Products> products = productsRepository.findById(id);
        if(products.isPresent()== false){
            return new ResponseEntity("Not_ Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(products, HttpStatus.OK);

    }
    @PutMapping(value ="/{id}")
    public ResponseEntity<Products> updateProducts(@PathVariable("id") int id ,@RequestBody Products productsForm){
        Optional<Products> products = productsRepository.findById(id);
        if(products.isPresent()== false){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            products.get().setCategory(productsForm.getCategory());
            products.get().setCreateDate(productsForm.getCreateDate());
            products.get().setUpdateDate(date);
            products.get().setName(productsForm.getName());
            Products proUpdate =   productsRepository.save(products.get());
            return new ResponseEntity("Success",HttpStatus.OK);
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id){
        Optional<Products> products = productsRepository.findById(id);
        if (products == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            productsRepository.delete(products.get());
            return new ResponseEntity("Xoá Thành Công!", HttpStatus.OK);
        }
    }
}
