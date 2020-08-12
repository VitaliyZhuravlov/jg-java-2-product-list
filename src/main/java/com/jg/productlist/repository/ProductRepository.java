package com.jg.productlist.repository;
import com.jg.productlist.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "select * from products e where e.name like %:keyword%", nativeQuery = true)
    List<Product> findByKeyword(@Param("keyword") String keyword);
}
