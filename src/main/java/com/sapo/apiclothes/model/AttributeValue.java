package com.sapo.apiclothes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Table(name ="attributevalue")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name ="name")
    private String name;
    @ManyToOne
    @JoinColumn(name="id_attribute")
    private Attribute attribute;
    public AttributeValue() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
