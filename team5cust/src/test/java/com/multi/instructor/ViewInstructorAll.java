package com.multi.instructor;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.InstructorDTO;
import com.multi.service.InstructorService;

@SpringBootTest
class ViewInstructorAll {
	
	@Autowired
	InstructorService service;
	
	@Test
	void contextLoads() {
		
		List<InstructorDTO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(InstructorDTO i:list) {
			System.out.println(i);
		}
		
	}

}