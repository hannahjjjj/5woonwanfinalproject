package com.multi.visit;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.VisitDTO;
import com.multi.service.VisitService;


@SpringBootTest
class InsertVisit {

	@Autowired
	VisitService service;
	
	@Test
	void contextLoads() {
		Date day=new Date();
		VisitDTO visit = new VisitDTO(0, 20000, day);
		try {
			service.register(visit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(visit);
		}
		
	}

}




