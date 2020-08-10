package com.jg.productlist.service;
import com.jg.productlist.domain.Product;
import com.jg.productlist.repository.ProductRepository;
import com.jg.productlist.validation.ProductNotFoundException;
import com.jg.productlist.validation.ProductValidationService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductValidationService productValidationService;

    public ProductService(ProductRepository productRepository,
                          ProductValidationService productValidationService) {
        this.productRepository = productRepository;
        this.productValidationService = productValidationService;
    }

    public Product findById(Long id){
        return productRepository.findProductById(id);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product saveProduct(Product product){
        productValidationService.validate(product);
        return productRepository.save(product);
    }

    public void update(Product product){
        productValidationService.validate(product);
        productRepository.update(product);
    }

    public void delete(Long id){
        productRepository.delete(id);
    }

    public Product findByName(String name){
        Product product = productRepository.findByName(name);
        if (product == null) {
            throw new ProductNotFoundException("Not found" + name);
        }
        return product;
    }
}