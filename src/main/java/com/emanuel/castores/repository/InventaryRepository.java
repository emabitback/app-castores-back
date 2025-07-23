package com.emanuel.castores.repository;

import com.emanuel.castores.entity.Inventary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventaryRepository extends JpaRepository<Inventary, Integer> {
}
