package com.sapo.apiclothes.controller;

import com.sapo.apiclothes.model.ProductDetail;
import com.sapo.apiclothes.model.Products;
import com.sapo.apiclothes.repository.Product_DetailRepository;
import com.sapo.apiclothes.repository.ProductsRepository;
import com.sapo.apiclothes.service.ProductDetailService;
import com.sapo.apiclothes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value ="/api/productDetail")
public class ApiProductDetail {
    @Autowired
    ProductDetailService productDetailService;
    @GetMapping
    public ResponseEntity<List<ProductDetail>> getAllProduct(){
        return productDetailService.getAllPD();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<ProductDetail>> getAllProductByID(@PathVariable("id") int id){
        return  productDetailService.getAllPDById(id);
    }
   @PostMapping
    public ResponseEntity<String> addPro(@RequestBody ProductDetail productDetail){
       return productDetailService.addPro_Detail(productDetail);
   }
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updatePro(@PathVariable("id") int id,@RequestBody ProductDetail productDetail){
        return productDetailService.updateProductDeatil(id,productDetail);
    }
   @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteByIdPd(@PathVariable("id") int id){
        return   productDetailService.deletePdById(id);
   }

}
