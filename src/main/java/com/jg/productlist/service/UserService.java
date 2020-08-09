package com.jg.productlist.service;
import com.jg.productlist.domain.Product;
import com.jg.productlist.domain.User;
import com.jg.productlist.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User findUserById(Long userId) {
        return userRepository.findUserById(userId);
    }

    public void update(User user){
        userRepository.update(user);
    }

    public void delete(Long id){
        userRepository.delete(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
