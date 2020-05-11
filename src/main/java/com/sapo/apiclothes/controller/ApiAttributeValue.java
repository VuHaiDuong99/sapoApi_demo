package com.sapo.apiclothes.controller;

import com.sapo.apiclothes.model.Attribute;
import com.sapo.apiclothes.model.AttributeValue;
import com.sapo.apiclothes.repository.AttributeReponsitory;
import com.sapo.apiclothes.repository.AttributeValueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/attributevalue")
@CrossOrigin(origins = "*")
public class ApiAttributeValue {
    @Autowired
    AttributeValueRepository attributeValue;
    @GetMapping
    public ResponseEntity<List<AttributeValue>> getAllAttribute(){
        List list=   attributeValue.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<AttributeValue> getAllAttributeById(@PathVariable("id") int id){
        Optional<AttributeValue> attribute = attributeValue.findById(id);
        if(attribute.isPresent()== false){
            return new ResponseEntity("Not_ Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(attribute, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> addAttribute(@RequestBody AttributeValue attributeForm){
        attributeValue.save(attributeForm);
        return new ResponseEntity("Success", HttpStatus.OK);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<AttributeValue> updateAttribute(@PathVariable("id") int id,@RequestBody AttributeValue attributeForm){
        Optional<AttributeValue> attributeVl = attributeValue.findById(id);
        if(attributeVl.isPresent()== false){
            return new ResponseEntity("Not_ Found",HttpStatus.NOT_FOUND);
        }
        attributeVl.get().setName(attributeForm.getName());
        attributeValue.save(attributeVl.get());
        return new ResponseEntity("Success", HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAttribute(@PathVariable("id") int id){
        AttributeValue attribute = attributeValue.getOne(id);
        attributeValue.delete(attribute);
        return new ResponseEntity("Success", HttpStatus.OK);
    }
}
