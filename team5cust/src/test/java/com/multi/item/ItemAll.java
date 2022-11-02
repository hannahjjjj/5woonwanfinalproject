package com.multi.item;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemDTO;
import com.multi.dto.ReviewDTO;
import com.multi.service.ItemService;

@SpringBootTest
class ItemAll {
	
	@Autowired
	ItemService service;
	
	@Test
	void contextLoads() {
		
		List<ItemDTO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(ItemDTO i:list) {
			System.out.println(i);
		}
		
	}

}