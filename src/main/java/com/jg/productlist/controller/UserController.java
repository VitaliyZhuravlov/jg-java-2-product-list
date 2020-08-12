package com.jg.productlist.controller;

import com.jg.productlist.domain.User;
import com.jg.productlist.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @GetMapping("/findAllUsers")
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/findById/{id}")
    public User findUserById(@PathVariable Long id) {
        return service.findUserById(id);
    }

    @GetMapping("/user/{username}")
    public User findUserByName(@PathVariable String username) {
        return service.findUserByName(username);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
