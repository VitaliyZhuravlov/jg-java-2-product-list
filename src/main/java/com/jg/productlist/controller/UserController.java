package com.jg.productlist.controller;


import com.jg.productlist.domain.User;
import com.jg.productlist.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user-list")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
       userService.save(user);
        return "redirect:/user-list";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long userId, Model model){
        User user = userService.findUserById(userId);
        model.addAttribute("user",user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.save(user);
        return "redirect:/user-list";
    }

    @GetMapping("user-delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/user-list";
    }

    @GetMapping("/users")
    public String findByKeyword(Model model, String keyword){
        if(keyword !=null){
            model.addAttribute("users",userService.findByKeyword(keyword));
        } else {
            model.addAttribute("users",userService.findAll());
        }
        return "user-list";
    }
}
