package com.multi.instructor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.InstructorService;

@SpringBootTest
class DeleteItem {
	
	@Autowired
	InstructorService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(1057);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
