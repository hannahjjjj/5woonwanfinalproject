package com.multi.orders;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemDTO;
import com.multi.dto.OrdersDTO;
import com.multi.service.OrdersService;


@SpringBootTest
class UpdateOrders {
	@Autowired
	OrdersService service;
	
	@Test
	void contextLoads() {
		Date day=new Date();
		OrdersDTO order = new OrdersDTO(208,101,"id08",day,null,0,0,0);
		try {
			service.modify(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
