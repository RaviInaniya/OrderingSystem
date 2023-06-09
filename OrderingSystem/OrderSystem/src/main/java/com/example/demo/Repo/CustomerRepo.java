package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entitys.Customer;
import com.example.demo.Entitys.OrderItems;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	@Query(value = "SELECT * FROM customer where oId=?1", nativeQuery = true)
	   public OrderItems getOrderById(int oId);
}
