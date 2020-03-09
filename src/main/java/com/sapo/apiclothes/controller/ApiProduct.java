package com.sapo.apiclothes.controller;

import com.sapo.apiclothes.model.ProductDetail;
import com.sapo.apiclothes.model.Products;
import com.sapo.apiclothes.repository.Product_DetailRepository;
import com.sapo.apiclothes.repository.ProductsRepository;
import com.sapo.apiclothes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api/product")
public class ApiProduct {
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    ProductService productService;
    @Autowired
    Product_DetailRepository pdr;
    @GetMapping
    public ResponseEntity<List<Products>> getAllProduct(){
       return  productService.getAllProduct();
    }
    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Products productForm){
        return productService.addProduct(productForm);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Products> getProductByID(@PathVariable("id") int id){
        return productService.getProductById(id);
    }
    @PutMapping(value ="/{id}")
    public ResponseEntity<Products> updateProducts(@PathVariable("id") int id ,@RequestBody Products products){
       return productService.updateProduct(products,id);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id){
        return productService.deleteProductById(id);
    }
}
