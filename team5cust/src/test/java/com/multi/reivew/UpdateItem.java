package com.multi.reivew;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ReviewDTO;
import com.multi.service.ReviewService;


@SpringBootTest
class UpdateItem {
	@Autowired
	ReviewService service;
	
	@Test
	void contextLoads() {
		ReviewDTO item = new ReviewDTO();
		try {
			service.modify(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
