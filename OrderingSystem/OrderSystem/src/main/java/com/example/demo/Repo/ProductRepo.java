package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entitys.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
