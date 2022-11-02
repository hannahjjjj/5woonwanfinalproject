package com.multi.orders;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemDTO;
import com.multi.dto.OrdersDTO;
import com.multi.service.OrdersService;

@SpringBootTest
class OrdersAll {
	
	@Autowired
	OrdersService service;
	
	@Test
	void contextLoads() {
		
		List<OrdersDTO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(OrdersDTO i:list) {
			System.out.println(i);
		}
		
	}

}