package com.multi.orders;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.OrdersService;

@SpringBootTest
class DeleteOrders {
	
	@Autowired
	OrdersService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(208);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
