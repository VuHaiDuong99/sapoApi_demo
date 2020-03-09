package com.sapo.apiclothes.service;

import com.sapo.apiclothes.model.Attribute;
import com.sapo.apiclothes.model.Category;
import com.sapo.apiclothes.repository.AttributeReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AttributeService {
    @Autowired
    AttributeReponsitory attributeReponsitory;
    public ResponseEntity<List<Attribute>> getAllAttribute(){
        List list=   attributeReponsitory.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    public ResponseEntity<Attribute> getAllAttributeId(int id){
        Attribute attribute =   attributeReponsitory.getOne(id);
        return new ResponseEntity(attribute, HttpStatus.OK);
    }
    public ResponseEntity<String> addAttribute(@RequestBody Attribute attributeForm){
        attributeReponsitory.save(attributeForm);
        return new ResponseEntity("Success", HttpStatus.OK);
    }
    public ResponseEntity<String> updateAttribute(int id,@RequestBody Attribute attributeForm){
        Attribute attribute = attributeReponsitory.getOne(id);
        attribute.setName(attributeForm.getName());
        attributeReponsitory.save(attribute);
        return new ResponseEntity("Success", HttpStatus.OK);
    }
    public ResponseEntity<String> deleteAttribute(int id){
        Attribute attribute = attributeReponsitory.getOne(id);
        attributeReponsitory.delete(attribute);
        return new ResponseEntity("Success", HttpStatus.OK);
    }

}
