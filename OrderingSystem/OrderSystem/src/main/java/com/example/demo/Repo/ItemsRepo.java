package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entitys.Items;

public interface ItemsRepo extends JpaRepository<Items, Integer> {

}
