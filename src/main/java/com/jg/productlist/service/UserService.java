package com.jg.productlist.service;
import com.jg.productlist.domain.User;
import com.jg.productlist.repository.UserRepository;
import com.jg.productlist.service.validation.ProductNotFoundException;
import com.jg.productlist.service.validation.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        return repository.save(user);
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public User findUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("User not found, id = " + id));
    }

    public User findUserByName(String username) {
        return repository.findByName(username);
    }

    public String delete(Long id) {
        repository.deleteById(id);
        return "Successfully deleted" + id;
    }

    public User updateUser(User user) {
        User newUserDetails = repository.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        newUserDetails.setUsername(user.getUsername());
        return repository.save(newUserDetails);
    }
}
