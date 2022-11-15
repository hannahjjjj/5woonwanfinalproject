package com.multi.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemDTO;
import com.multi.service.ItemService;


@SpringBootTest
class UpdateItem {
	@Autowired
	ItemService service;
	
	@Test
	void contextLoads() {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
