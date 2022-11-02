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
		ItemDTO item = new ItemDTO(101,100,200,"PT","a.jpg", 10, 0, 550000, "Y", null);
		try {
			service.modify(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
