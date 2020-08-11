package com.jg.productlist.controller;
import com.jg.productlist.domain.User;
import com.jg.productlist.dto.OrderResponse;
import com.jg.productlist.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class InfoController
{
    private final UserRepository userRepository;

    public InfoController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/getJoinInfo")
    public String getJoin(Model model){
        List<OrderResponse> orderResponses = userRepository.getJoinInformation();
        model.addAttribute("response", orderResponses);
        return "join-info";
    }

    @GetMapping("/findAllOrders")
    public String findUserOrders(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("response", users);
        return "order-list";
    }
}
