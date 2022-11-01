package com.multi.instructor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.InstructorDTO;
import com.multi.service.InstructorService;


@SpringBootTest
class UpdateItem {
	@Autowired
	InstructorService service;
	
	@Test
	void contextLoads() {
		InstructorDTO item = new InstructorDTO();
		try {
			service.modify(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
