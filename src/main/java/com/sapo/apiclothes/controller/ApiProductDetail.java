package com.sapo.apiclothes.controller;

import com.sapo.apiclothes.model.Attribute;
import com.sapo.apiclothes.model.ProductDetail;
import com.sapo.apiclothes.model.Products;
import com.sapo.apiclothes.repository.Product_DetailRepository;
import com.sapo.apiclothes.repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value ="/api/productDetail")
public class ApiProductDetail {
    @Autowired
    Product_DetailRepository pdDetailRp;
    @GetMapping
    public ResponseEntity<List<ProductDetail>> getAllProduct(){
        List list = pdDetailRp.findAll();
        return new ResponseEntity<List<ProductDetail>>(list,HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<ProductDetail>> getAllProductByID(@PathVariable("id") int id){
        Optional<ProductDetail> productDetail = pdDetailRp.findById(id);
        if(productDetail.isPresent()== false){
            return new ResponseEntity("Not_ Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(productDetail, HttpStatus.OK);
    }
   @PostMapping
   @Transactional
    public ResponseEntity<ProductDetail> addPro(@RequestBody ProductDetail productDetail){
       int count = pdDetailRp.countidProduct(productDetail.getProduct().getId());
        if(count<3){
            pdDetailRp.save(productDetail);
       return new ResponseEntity<ProductDetail>(productDetail, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<ProductDetail>(HttpStatus.NO_CONTENT);
        }
   }
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updatePro(@PathVariable("id") int id,@RequestBody ProductDetail productDetailForm){
        Optional<ProductDetail> productDetail = pdDetailRp.findById(id);
        if(productDetail.isPresent()== false){
            return new ResponseEntity("Not_ Found",HttpStatus.NOT_FOUND);
        }
        else {

            productDetail.get().setAttributevalue(productDetailForm.getAttributevalue());
            productDetail.get().setProduct(productDetailForm.getProduct());
            pdDetailRp.save(productDetail.get());
            return new ResponseEntity<>("Success",HttpStatus.OK);
        }
    }
   @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteByIdPd(@PathVariable("id") int id){
       ProductDetail productDetail = pdDetailRp.getOne(id);
       pdDetailRp.delete(productDetail);
       return new ResponseEntity<>("Success",HttpStatus.OK);
   }

}
