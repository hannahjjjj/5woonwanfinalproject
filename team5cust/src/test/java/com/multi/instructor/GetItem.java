package com.multi.instructor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.InstructorDTO;
import com.multi.service.InstructorService;


@SpringBootTest
class GetItem {

	@Autowired
	InstructorService service;
	
	@Test
	void contextLoads() {
		InstructorDTO item = null;
		try {
			item = service.get(1056);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}




