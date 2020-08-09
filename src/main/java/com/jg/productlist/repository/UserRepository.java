package com.jg.productlist.repository;
import com.jg.productlist.domain.User;
import java.util.List;

public interface UserRepository {

    User save(User user);

    User findUserById(Long id);

    void delete(Long id);

    void update(User user);

    List<User> findAll();

}
