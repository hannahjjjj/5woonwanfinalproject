package com.multi.orders;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.OrdersDTO;
import com.multi.service.OrdersService;


@SpringBootTest
class GetOrders {

	@Autowired
	OrdersService service;
	
	@Test
	void contextLoads() {
		OrdersDTO order = null;
		try {
			order = service.get(100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(order);
	}

}




