package com.sapo.apiclothes.controller;

import com.sapo.apiclothes.model.Attribute;
import com.sapo.apiclothes.model.Category;
import com.sapo.apiclothes.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/attribute")
public class ApiAttribute {
    @Autowired
    AttributeService attributeService;
    @GetMapping
    public ResponseEntity<List<Attribute>> getAllAttribute(){
        return attributeService.getAllAttribute();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Attribute> getAllAttributeById(@PathVariable("id") int id){
        return attributeService.getAllAttributeId(id);
    }
    @PostMapping
    public ResponseEntity<String> addAttribute(@RequestBody Attribute attribute){
        return attributeService.addAttribute(attribute);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateAttribute(@PathVariable("id") int id,@RequestBody Attribute attribute){
        return attributeService.updateAttribute(id,attribute);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAttribute(@PathVariable("id") int id){
        return attributeService.deleteAttribute(id);
    }
}
