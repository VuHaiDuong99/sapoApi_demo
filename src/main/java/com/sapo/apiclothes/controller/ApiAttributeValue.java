package com.sapo.apiclothes.controller;

import com.sapo.apiclothes.model.Attribute;
import com.sapo.apiclothes.model.AttributeValue;
import com.sapo.apiclothes.service.AttributeService;
import com.sapo.apiclothes.service.AttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/attributevalue")
public class ApiAttributeValue {
    @Autowired
    AttributeValueService attributeValueService;
    @GetMapping
    public ResponseEntity<List<AttributeValue>> getAllAttribute(){
        return attributeValueService.getAllAttribute();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<AttributeValue> getAllAttributeById(@PathVariable("id") int id){
        return attributeValueService.getAllAttributeId(id);
    }
    @PostMapping
    public ResponseEntity<String> addAttribute(@RequestBody AttributeValue attribute){
        return attributeValueService.addAttribute(attribute);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateAttribute(@PathVariable("id") int id,@RequestBody AttributeValue attribute){
        return attributeValueService.updateAttribute(id,attribute);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAttribute(@PathVariable("id") int id){
        return attributeValueService.deleteAttribute(id);
    }
}
