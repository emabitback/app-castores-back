package com.emanuel.castores.controllers;

import com.emanuel.castores.entity.Inventary;
import com.emanuel.castores.entity.Products;
import com.emanuel.castores.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class InventaryController {

    @Autowired
    ProductService productService;


    @PostMapping("/inventary/list")
    public List<Inventary> getALl() {

        return productService.getInventory();
    }

    @PostMapping("/inventary/add")
    public ResponseEntity<Object> getString(@RequestBody Inventary i) {

        productService.addInventary(i);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        map.put("message", "producto en inventario correctamente");

        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
}
