package com.sapo.apiclothes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;



@Entity
@Table(name="products")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Products implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="name")
    private String name;
    @Column(name ="image")
    private String image;
    @Column(name ="price")
    private String price;
    @Column(name ="createdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date createDate;
    @Column(name ="updatedate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateDate;
    @ManyToOne
    @JoinColumn(name="id_category")
    private Category category;
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Products() {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
