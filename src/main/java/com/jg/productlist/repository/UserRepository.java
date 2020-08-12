package com.jg.productlist.repository;

import com.jg.productlist.domain.Product;
import com.jg.productlist.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String username);
}
