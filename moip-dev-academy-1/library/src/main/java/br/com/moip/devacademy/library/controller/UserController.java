package br.com.moip.devacademy.library.controller;

import br.com.moip.devacademy.library.entity.User;
import br.com.moip.devacademy.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by leticia.alves on 04/04/18.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId).get();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userDetails) {

        User user = userRepository.findById(userId).get();

        user.setName(userDetails.getName());
        user.setRole(userDetails.getRole());

        userRepository.save(user);

        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId).get();
        userRepository.delete(user);
    }
}
