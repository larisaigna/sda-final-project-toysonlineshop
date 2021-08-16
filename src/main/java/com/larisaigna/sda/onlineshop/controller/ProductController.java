package com.larisaigna.sda.onlineshop.controller;

import com.larisaigna.sda.onlineshop.model.Product;
import com.larisaigna.sda.onlineshop.service.CategoryService;
import com.larisaigna.sda.onlineshop.service.ProductService;
import com.larisaigna.sda.onlineshop.service.dto.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/product-list")
    public String showProductListPage(Model model) {
        model.addAttribute("products", productService.getAll());
        return "products-list";
    }

    @GetMapping("/add-product")
    public String addProduct(Model model) {
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("product_categories", categoryService.getAll());
        return "product-add";
    }

    @PostMapping("/addproduct")
    public String saveProduct(@ModelAttribute("product") @Valid ProductDTO productDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "product-add";
        }
        productService.save(productDTO);
        return "redirect:/product-list";
    }

    @GetMapping("/edit-product/{id}")
    public String editProduct(@PathVariable("id") Long productId, Model model) {
        ProductDTO productDTO = productService.findById(productId);
        model.addAttribute("product", productDTO);
        model.addAttribute("product_categories", categoryService.getAll());
        return "product-edit";
    }

    @PostMapping("/editproduct")
    public String editProduct(@ModelAttribute("product") ProductDTO productDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "product-edit";
        }
        productService.update(productDTO);
        return "redirect:/product-list";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable("id") Long productId) {
        ProductDTO productDTO = productService.findById(productId);
        productService.delete(productId);
        return "redirect:/product-list";
    }
}
