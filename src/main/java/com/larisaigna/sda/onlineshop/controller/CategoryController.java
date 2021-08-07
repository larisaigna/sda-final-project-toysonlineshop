package com.larisaigna.sda.onlineshop.controller;

import com.larisaigna.sda.onlineshop.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category-list")
    public String showCategoryListPage(Model model) {

        model.addAttribute("categories", categoryService.getAllRoot());
        return "category-list";
    }


}
