package com.emanuel.castores.services;

import com.emanuel.castores.entity.Inventary;
import com.emanuel.castores.repository.InventaryRepository;
import com.emanuel.castores.repository.ProductRepository;
import com.emanuel.castores.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    InventaryRepository inventaryRepository;

    public List<Products> getALlProducts(){
        return productRepository.findAll();
    }


    public void addProduct(Products product) {
         productRepository.save(product);
    }



    public List<Inventary> getInventory(){
        return inventaryRepository.findAll();

    }

    public void addInventary(Inventary inventary) {
        inventaryRepository.save(inventary);
    }

    public void updateProduct(Inventary inventary) {
        //inventaryRepository.
    }




}
