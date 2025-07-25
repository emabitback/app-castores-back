package com.emanuel.castores.repository;

import com.emanuel.castores.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Products, Integer> {
}