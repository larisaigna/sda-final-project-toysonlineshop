package com.larisaigna.sda.onlineshop.service;


import com.larisaigna.sda.onlineshop.model.Product;
import com.larisaigna.sda.onlineshop.repository.CategoryRepository;
import com.larisaigna.sda.onlineshop.repository.ProductRepository;
import com.larisaigna.sda.onlineshop.service.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAll() {

        return new ArrayList<Product>((Collection<? extends Product>) productRepository.findAll());
    }

    public void save(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setBrand(productDTO.getBrand());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setDestinationGender(productDTO.getDestinationGender());
        product.setDestinationAge(productDTO.getDestinationAge());
        product.setThumbnail(productDTO.getThumbnail());
        product.setCategory(categoryRepository.findById(productDTO.getProductCategoryId()).orElse(null));

        productRepository.save(product);

    }
}
