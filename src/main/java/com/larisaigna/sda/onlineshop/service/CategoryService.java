package com.larisaigna.sda.onlineshop.service;

import com.larisaigna.sda.onlineshop.model.Category;
import com.larisaigna.sda.onlineshop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public List<Category> getAllRoot() {
        return StreamSupport.stream(categoryRepository.findAllByParentIsNull().spliterator(), false).collect(Collectors.toList());
    }
}
