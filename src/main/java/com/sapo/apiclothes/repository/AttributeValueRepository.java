package com.sapo.apiclothes.repository;

import com.sapo.apiclothes.model.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeValueRepository extends JpaRepository<AttributeValue,Integer> {
}
