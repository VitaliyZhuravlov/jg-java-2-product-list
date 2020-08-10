package com.jg.productlist.repository;
import com.jg.productlist.domain.Product;
import java.util.List;

public interface ProductRepository {

    Product save (Product product);

    Product findProductById(Long id);

    void delete(Long id);

    void update(Product product);

    List<Product> findAll();

    Product findByName(String name);
}
