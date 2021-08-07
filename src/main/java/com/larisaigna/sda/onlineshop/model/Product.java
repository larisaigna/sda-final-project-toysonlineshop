package com.larisaigna.sda.onlineshop.model;


import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "destination_gender")
    private DestinationGender destinationGender;

    @Enumerated(EnumType.STRING)
    @Column(name = "destination_age")
    private DestinationAge destinationAge;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "thumbnail")
    private String thumbnail;

    public Product(Long id, String name, String brand, Double price, String description, DestinationGender destinationGender, DestinationAge destinationAge, Category category, String thumbnail) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.destinationGender = destinationGender;
        this.destinationAge = destinationAge;
        this.category = category;
        this.thumbnail = thumbnail;
    }

    public Product() {

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", destinationGender=" + destinationGender +
                ", destinationAge=" + destinationAge +
                ", category=" + category +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
