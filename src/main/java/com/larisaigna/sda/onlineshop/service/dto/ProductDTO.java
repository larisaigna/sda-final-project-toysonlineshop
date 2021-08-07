package com.larisaigna.sda.onlineshop.service.dto;

import com.larisaigna.sda.onlineshop.model.DestinationAge;
import com.larisaigna.sda.onlineshop.model.DestinationGender;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class ProductDTO {

    private Long id;
    private String name;
    private String brand;
    private Double price;
    private String description;
    private String thumbnail;
    private DestinationGender destinationGender;
    private DestinationAge destinationAge;

    private Long productCategoryId;

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public DestinationGender getDestinationGender() {
        return destinationGender;
    }

    public void setDestinationGender(DestinationGender destinationGender) {
        this.destinationGender = destinationGender;
    }

    public DestinationAge getDestinationAge() {
        return destinationAge;
    }

    public void setDestinationAge(DestinationAge destinationAge) {
        this.destinationAge = destinationAge;
    }
}
