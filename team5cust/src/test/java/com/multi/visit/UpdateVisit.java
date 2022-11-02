package com.multi.visit;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.VisitDTO;
import com.multi.service.VisitService;


@SpringBootTest
class UpdateVisit {
	@Autowired
	VisitService service;
	
	@Test
	void contextLoads() {
		Date day=new Date();
		VisitDTO order = new VisitDTO(101,30000,day);
		try {
			service.modify(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
