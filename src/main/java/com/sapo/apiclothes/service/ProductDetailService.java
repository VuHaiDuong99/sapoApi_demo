package com.sapo.apiclothes.service;

import com.sapo.apiclothes.model.ProductDetail;
import com.sapo.apiclothes.repository.Product_DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductDetailService {
    @Autowired
    Product_DetailRepository product_detailRepository;
    public ResponseEntity<List<ProductDetail>> getAllPD(){
        List list = product_detailRepository.findAll();
        return new ResponseEntity<List<ProductDetail>>(list,HttpStatus.OK);
    }
    public ResponseEntity<String> addPro_Detail(ProductDetail productDetail){
        int count = product_detailRepository.countidProduct(productDetail.getProduct().getId());
        if(count<3){
            product_detailRepository.save(productDetail);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Moi San Pham Chi Duoc Chon Khong Qua 3",HttpStatus.OK);
        }
    }
    public ResponseEntity<List<ProductDetail>> getAllPDById(int id){
        List list = product_detailRepository.getAllPDById(id);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    public ResponseEntity<String> deletePdById(int id){
        ProductDetail productDetail = product_detailRepository.getOne(id);
        product_detailRepository.delete(productDetail);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }
    public ResponseEntity<String> updateProductDeatil(int id, @RequestBody ProductDetail productDetailForm){
        ProductDetail productDetail = product_detailRepository.getOne(id);
        productDetail.setAttributevalue(productDetailForm.getAttributevalue());
        productDetail.setProduct(productDetailForm.getProduct());
        product_detailRepository.save(productDetail);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

}

