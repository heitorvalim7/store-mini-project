package com.ufes.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufes.miniproject.model.Product;

import java.util.List;

// jpa repository is a pre-built interface in Spring Data JPA that lets Java applications talk to a database without writing standard SQL queries
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByNameContainingIgnoreCase(String name);
}
