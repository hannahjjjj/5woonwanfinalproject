package com.multi.reivew;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ReviewDTO;
import com.multi.service.ReviewService;


@SpringBootTest
class InsertReview {

	@Autowired
	ReviewService service;
	
	@Test
	void contextLoads() {
		ReviewDTO item = new ReviewDTO(100,100,"dbswlsgh","별로","1");
		try {
			service.register(item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}




