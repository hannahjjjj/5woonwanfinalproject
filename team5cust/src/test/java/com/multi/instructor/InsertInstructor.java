package com.multi.instructor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.InstructorDTO;
import com.multi.service.InstructorService;


@SpringBootTest
class InsertInstructor {

	@Autowired
	InstructorService service;
	
	@Test
	void contextLoads() {
		InstructorDTO instructor = new InstructorDTO(100,100,"윤진호","헬린이","a","a-1","aaa@aa.com","01000000000");
		try {
			service.register(instructor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}




