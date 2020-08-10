package com.jg.productlist.controller;
import com.jg.productlist.domain.Product;
import com.jg.productlist.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String findAll(Model model) {
            List<Product> products = productService.findAll();
            model.addAttribute("products",products);
        return "product-list";
    }

    @GetMapping("/product-create")
    public String createProductForm(Product product) {
        return "product-create";
    }

    @PostMapping("/product-create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/product-update/{id}")
    public String updateProductForm(@PathVariable("id") Long productId, Model model) {
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        return "product-update";
    }

    @PostMapping("/product-update")
    public String updateProduct(Product product) {
        productService.update(product);
        return "redirect:/products";
    }

    @GetMapping("product-delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        productService.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/products/{name}")
    public String findByName(Model model,@PathVariable String name){
            model.addAttribute("products", productService.findByName(name));
        return "product-list";
    }
}
