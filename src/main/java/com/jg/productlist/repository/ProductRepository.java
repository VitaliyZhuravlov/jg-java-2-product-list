package com.jg.productlist.repository;
import com.jg.productlist.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save (Product product);

    Product findProductById(Long id);

    void delete(Long id);

    void update(Product product);

    List<Product> findAll();

}
