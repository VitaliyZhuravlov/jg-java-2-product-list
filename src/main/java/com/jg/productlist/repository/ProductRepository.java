package com.jg.productlist.repository;

import com.jg.productlist.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
  //  Product findByName(String name);
}
