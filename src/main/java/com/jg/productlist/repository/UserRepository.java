package com.jg.productlist.repository;

import com.jg.productlist.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserById(Long userId);

    @Query(value = "select * from users e where e.id like %:keyword%",nativeQuery = true)
    List<User> findByKeyword(@Param("keyword") String keyword);
}
