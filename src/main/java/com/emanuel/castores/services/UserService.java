package com.emanuel.castores.services;

import com.emanuel.castores.entity.Users;
import com.emanuel.castores.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(Users user) {
        userRepository.save(user);
    }
}
