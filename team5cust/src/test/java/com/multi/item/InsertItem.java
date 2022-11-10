package com.multi.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemDTO;
import com.multi.service.ItemService;


@SpringBootTest
class InsertItem {

	@Autowired
	ItemService service;
	
	@Test
	void contextLoads() {
		ItemDTO item = new ItemDTO(0, 101, 201, "PT", "b.jpg", 10, 0, 0, null, null, null);
		try {
			service.register(item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(item);
		}
		
	}

}




