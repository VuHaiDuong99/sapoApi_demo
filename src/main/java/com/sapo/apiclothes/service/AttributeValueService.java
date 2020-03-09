package com.sapo.apiclothes.service;


import com.sapo.apiclothes.model.Attribute;
import com.sapo.apiclothes.model.AttributeValue;
import com.sapo.apiclothes.repository.AttributeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AttributeValueService {
    @Autowired
    AttributeValueRepository attributeValueRepository;
    public ResponseEntity<List<AttributeValue>> getAllAttribute(){
        List list=   attributeValueRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    public ResponseEntity<AttributeValue> getAllAttributeId(int id){
        AttributeValue attributeValue =   attributeValueRepository.getOne(id);
        return new ResponseEntity(attributeValue, HttpStatus.OK);
    }
    public ResponseEntity<String> addAttribute(@RequestBody AttributeValue attributeForm){
        attributeValueRepository.save(attributeForm);
        return new ResponseEntity("Success", HttpStatus.OK);
    }
    public ResponseEntity<String> updateAttribute(int id,@RequestBody AttributeValue attributeForm){
        AttributeValue attribute = attributeValueRepository.getOne(id);
        attribute.setName(attributeForm.getName());
        attributeValueRepository.save(attribute);
        return new ResponseEntity("Success", HttpStatus.OK);
    }
    public ResponseEntity<String> deleteAttribute(int id){
        AttributeValue attribute = attributeValueRepository.getOne(id);
        attributeValueRepository.delete(attribute);
        return new ResponseEntity("Success", HttpStatus.OK);
    }
}
