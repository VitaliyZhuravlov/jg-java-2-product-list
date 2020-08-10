package com.jg.productlist.service;
import com.jg.productlist.domain.Product;
import com.jg.productlist.repository.ProductRepository;
import com.jg.productlist.validation.ProductNotFoundException;
import com.jg.productlist.validation.ProductValidationService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductValidationService productValidationService;

    public ProductService(ProductRepository productRepository,
                          ProductValidationService productValidationService) {
        this.productRepository = productRepository;
        this.productValidationService = productValidationService;
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
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
        productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

   public List<Product> findByKeyword(String keyword){
        return productRepository.findByKeyword(keyword);
   }
}