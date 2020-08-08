package com.jg.productlist.repository;

import com.jg.productlist.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
