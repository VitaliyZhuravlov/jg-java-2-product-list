package com.jg.productlist.controller;

import com.jg.productlist.domain.Product;
import com.jg.productlist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping({"/", "/greeting"})
    public String greeting(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/product-list")
    public String findAll(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("/product-create")
    public String createProductForm(Product product){
        return "product-create";
    }

    @PostMapping("/product-create")
    public String createProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/product-list";
    }

    @GetMapping("/product-update/{id}")
    public String updateProductForm(@PathVariable("id") Long id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "product-update";
  }

  @PostMapping("/product-update")
    public String updateProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/product-list";
  }

  @GetMapping("product-delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.deleteById(id);
        return "redirect:/product-list";
  }
}
