package com.multi.reivew;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ReviewDTO;
import com.multi.service.ReviewService;

@SpringBootTest
class SelectItemAll {
	
	@Autowired
	ReviewService service;
	
	@Test
	void contextLoads() {
		
		List<ReviewDTO> list = null;
		try {
//			list = service.selectItemAll(11);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(ReviewDTO i:list) {
			System.out.println(i);
		}
		
	}

}