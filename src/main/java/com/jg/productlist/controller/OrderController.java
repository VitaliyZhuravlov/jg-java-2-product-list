package com.jg.productlist.controller;
import com.jg.productlist.domain.User;
import com.jg.productlist.dto.OrderRequest;
import com.jg.productlist.dto.OrderResponse;
import com.jg.productlist.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private final UserRepository userRepository;

    public OrderController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/placeOrder")
    public User placeOrder(@RequestBody OrderRequest request){
        return userRepository.save(request.getUser());
    }

}
