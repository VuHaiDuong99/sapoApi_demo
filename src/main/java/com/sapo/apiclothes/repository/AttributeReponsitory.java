package com.sapo.apiclothes.repository;

import com.sapo.apiclothes.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeReponsitory extends JpaRepository<Attribute,Integer> {
}
