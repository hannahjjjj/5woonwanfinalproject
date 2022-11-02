package com.multi.visit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.VisitDTO;
import com.multi.service.VisitService;


@SpringBootTest
class GetVisit {

	@Autowired
	VisitService service;
	
	@Test
	void contextLoads() {
		VisitDTO visit = null;
		try {
			visit = service.get(100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(visit);
	}

}




