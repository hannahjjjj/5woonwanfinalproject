package com.multi.instructor;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.InstructorDTO;
import com.multi.service.InstructorService;

@SpringBootTest
class SelectItemAll {
	
	@Autowired
	InstructorService service;
	
	@Test
	void contextLoads() {
		
		List<InstructorDTO> list = null;
		try {
		//	list = service.selectItemAll(11);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(InstructorDTO i:list) {
			System.out.println(i);
		}
		
	}

}