package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entitys.Items;
import com.example.demo.Entitys.OrderItems;

public interface OrderRepo extends JpaRepository<OrderItems, Integer>{
	
		@Query(value = "SELECT * FROM OrderItems where id=?1", nativeQuery = true)
		public List<Items> getOrderList(int oId);
	
}
