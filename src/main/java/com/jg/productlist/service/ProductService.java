package com.jg.productlist.service;

import com.jg.productlist.domain.Product;
import com.jg.productlist.repository.ProductRepository;
import com.jg.productlist.service.validation.ProductNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found, id=" + id));
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(Long id) {
        repository.deleteById(id);
        return "Successfully deleted" + id;
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDiscount(product.getDiscount());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategory(product.getCategory());
        return repository.save(existingProduct);
    }
}
