package com.sapo.apiclothes.controller;

import com.sapo.apiclothes.model.Attribute;
import com.sapo.apiclothes.model.Category;
import com.sapo.apiclothes.repository.AttributeReponsitory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/attribute")
public class ApiAttribute {
    @Autowired
    AttributeReponsitory attributeReponsitory;
    @GetMapping
    public ResponseEntity<List<Attribute>> getAllAttribute(){
        List list=   attributeReponsitory.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Attribute> getAllAttributeById(@PathVariable("id") int id){
        Optional<Attribute> attribute = attributeReponsitory.findById(id);
        if(attribute.isPresent()== false){
            return new ResponseEntity("Not_ Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(attribute, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> addAttribute(@RequestBody Attribute attributeForm){
        attributeReponsitory.save(attributeForm);
        return new ResponseEntity("Success", HttpStatus.OK);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateAttribute(@PathVariable("id") int id,@RequestBody Attribute attributeForm){
        Optional<Attribute> attribute = attributeReponsitory.findById(id);
        if(attribute.isPresent()== false){
            return new ResponseEntity("Not_ Found",HttpStatus.NOT_FOUND);
        }
        attribute.get().setName(attributeForm.getName());
        attributeReponsitory.save(attribute.get());
        return new ResponseEntity("Success", HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAttribute(@PathVariable("id") int id){
        Attribute attribute = attributeReponsitory.getOne(id);
        attributeReponsitory.delete(attribute);
        return new ResponseEntity("Success", HttpStatus.OK);
    }
}
