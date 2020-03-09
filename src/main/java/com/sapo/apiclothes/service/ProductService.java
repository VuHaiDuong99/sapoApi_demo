package com.sapo.apiclothes.service;

import com.sapo.apiclothes.model.Category;
import com.sapo.apiclothes.model.ProductDetail;
import com.sapo.apiclothes.model.Products;
import com.sapo.apiclothes.repository.CategoryRepository;
import com.sapo.apiclothes.repository.Product_DetailRepository;
import com.sapo.apiclothes.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    Product_DetailRepository product_detailRepository;
    public ResponseEntity<String>  addProduct(@RequestBody Products productAdd){
        Products products = new Products();
            if(productAdd.getName().isEmpty()){
               return new ResponseEntity<>("Name Null!!!",HttpStatus.OK);
            }
            if(productAdd.getCategory()==null){
                return new ResponseEntity<>("Category Null!!!",HttpStatus.OK);
            }
            if(productAdd.getCreateDate()==null){
                return new ResponseEntity<>("CreateDate Null!!!",HttpStatus.OK);
            }
            productsRepository.save(productAdd);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    public ResponseEntity<Products> updateProduct(@RequestBody Products productsForm,int id){
        Products products = productsRepository.getOne(id);
        if(products == null){
            return new ResponseEntity("Not Found",HttpStatus.OK);
        }
        else{
            products.setCategory(productsForm.getCategory());
            products.setCreateDate(productsForm.getCreateDate());
            products.setUpdateDate(products.getUpdateDate());
            products.setName(productsForm.getName());
            Products proUpdate =   productsRepository.save(products);
            return new ResponseEntity("Success",HttpStatus.OK);
        }
    }
    public ResponseEntity<Products> getProductById(int id){
        Products products = productsRepository.getOne(id);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
    public  ResponseEntity<List<Products>> getAllProduct(){
        List list = productsRepository.findAll();
        return  new ResponseEntity<>(list,HttpStatus.OK);
    }
    public ResponseEntity<String> deleteProductById(int id){
        Products products = productsRepository.getOne(id);
        productsRepository.delete(products);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }
}
