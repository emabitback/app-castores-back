package com.emanuel.castores.controllers;

import com.emanuel.castores.entity.Products;
import com.emanuel.castores.entity.Users;
import com.emanuel.castores.services.ProductService;
import com.emanuel.castores.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users/list")
    public List<Users> getALl() {
        return userService.getAllUsers();
        //return "Lista de Usuarios: " + userService.getAllUsers().toString();
    }
}
