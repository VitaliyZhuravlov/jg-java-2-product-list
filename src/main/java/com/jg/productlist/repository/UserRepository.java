package com.jg.productlist.repository;
import com.jg.productlist.domain.User;
import com.jg.productlist.dto.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT new com.jg.productlist.dto.OrderResponse(c.username , p.name ) FROM User c JOIN c.products p")
    List<OrderResponse> getJoinInformation();
}
