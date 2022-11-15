package com.multi.instructor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.InstructorDTO;
import com.multi.service.InstructorService;


@SpringBootTest
class UpdateInstructor {
	@Autowired
	InstructorService service;
	
	@Test
	void contextLoads() {
		InstructorDTO item = new InstructorDTO(102,100,"윤진호","헬린이","b","b-1","vvv@vv.com","01000000000");
		try {
			service.modify(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
