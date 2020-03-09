package com.sapo.apiclothes.repository;

import com.sapo.apiclothes.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface Product_DetailRepository extends JpaRepository<ProductDetail,Integer> {
    @Query("SELECT count(pd.product.id) FROM ProductDetail pd \n" +
            "where pd.product.id =:id")
    public Integer countidProduct(@Param("id") Integer id);
    @Query("SELECT pd FROM ProductDetail pd \n" +
            "where pd.product.id =:id")
    public List<ProductDetail> getAllPDById(@Param("id") Integer id);

}
