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

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
       userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long userId, Model model){
        User user = userService.findUserById(userId);
        model.addAttribute("user",user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String delete(@PathVariable("id") Long id,Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String findById(Model model,@PathVariable Long id){
        model.addAttribute("users", userService.findUserById(id));
        return "user-list";
    }
}
