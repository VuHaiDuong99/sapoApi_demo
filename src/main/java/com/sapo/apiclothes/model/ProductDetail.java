package com.sapo.apiclothes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Table(name ="product_detail")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @ManyToOne
    @JoinColumn(name="id_attributevalue")
    private AttributeValue attributevalue;
    @ManyToOne
    @JoinColumn(name="id_product")
    private Products product;

    public ProductDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AttributeValue getAttributevalue() {
        return attributevalue;
    }

    public void setAttributevalue(AttributeValue attributevalue) {
        this.attributevalue = attributevalue;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }


}
