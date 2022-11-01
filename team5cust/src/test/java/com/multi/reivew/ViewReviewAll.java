package com.multi.reivew;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ReviewDTO;
import com.multi.service.ReviewService;

@SpringBootTest
class ViewReviewAll {
	
	@Autowired
	ReviewService service;
	
	@Test
	void contextLoads() {
		
		List<ReviewDTO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(ReviewDTO i:list) {
			System.out.println(i);
		}
		
	}

}