package com.multi.visit;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.VisitDTO;
import com.multi.service.VisitService;

@SpringBootTest
class VisitAll {
	
	@Autowired
	VisitService service;
	
	@Test
	void contextLoads() {
		
		List<VisitDTO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(VisitDTO i:list) {
			System.out.println(i);
		}
		
	}

}