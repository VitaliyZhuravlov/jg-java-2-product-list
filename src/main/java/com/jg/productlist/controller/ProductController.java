package com.jg.productlist.controller;
import com.jg.productlist.domain.Product;
import com.jg.productlist.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product-list")
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
        Optional<Product> product = productService.findById(productId);
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
        Optional<Product> product = productService.findById(id);
        model.addAttribute("product", product);
        productService.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String findByKeyword(Model model, String keyword){
        if(keyword !=null){
            model.addAttribute("products", productService.findByKeyword(keyword));
        } else {
            model.addAttribute("products",productService.findAll());
        }
        return "product-list";
    }
}
