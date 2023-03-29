package com.example.demo.Controllers;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entitys.Customer;
import com.example.demo.Entitys.Items;
import com.example.demo.Entitys.OrderItems;
import com.example.demo.Entitys.Product;
import com.example.demo.Repo.CustomerRepo;
import com.example.demo.Repo.ItemsRepo;
import com.example.demo.Repo.OrderRepo;
import com.example.demo.Repo.ProductRepo;

@RestController
public class MyController {
	
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	ProductRepo productRepo;
	@Autowired
	ItemsRepo itemsRepo;
	@Autowired
	OrderRepo orderRepo;
	
	

	// Register User
	
	// Login User With Authentication
	
	// Add Product
	
	
	//Add To Cart
	@RequestMapping("AddToCart/{cId}/{oId}/{pId}/{qty}")
	public boolean addToCart(@PathVariable int cId, @PathVariable int oId, @PathVariable int pId,@PathVariable int qty)
	{
		try {
			
			Customer customer=customerRepo.findById(cId).get();
			List<OrderItems> it=customer.getOrders();
			OrderItems order=it.get(oId-1);
			List<Items> items2=order.getItems();
			Product product=productRepo.findById(pId).get();
			
			Items item=new Items();
			item.setProduct(product);
			item.setQuantity(qty);
			itemsRepo.save(item);
			items2.add(item);
			
			order.setTotalPrice(order.getTotalPrice()+(product.getPrice()*qty));
			
			orderRepo.save(order);
			customerRepo.save(customer);
			
			product.setQuantity((product.getQuantity()-qty));
			productRepo.save(product);
			
			return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	
	// CheckOut it will Provide Discount as per the number of items purchases in an Order
	
	@RequestMapping("CheckOut/{cId}/{oId}")
	public boolean checkOut(@PathVariable int cId,@PathVariable int oId)
	{
		try {
			
			Customer customer=customerRepo.findById(cId).get();
			List<OrderItems> it=customer.getOrders();
			OrderItems order=it.get(oId-1);
			List<Items> items=order.getItems();
			if(items.size()>20)
			{
				order.setTotalPrice(order.getTotalPrice()-(order.getTotalPrice()*0.20));
			}
			else if(items.size()>10)
			{
				order.setTotalPrice(order.getTotalPrice()-(order.getTotalPrice()*0.10));
			}
			
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			
			return false;
		}
	}
	
	
	
	
}
