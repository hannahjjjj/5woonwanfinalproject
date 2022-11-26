package com.multi.reivew;

import java.util.Date;

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
		Date day=new Date();
		ReviewDTO item = new ReviewDTO(0,100,"dbswlsgh1238","별로",2,day);
		try {
			service.register(item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}




