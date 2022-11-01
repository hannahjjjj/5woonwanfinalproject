package com.multi.schedules;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.SchedulesDTO;
import com.multi.service.SchedulesService;

@SpringBootTest
class ViewschedulesAll {
	
	@Autowired
	SchedulesService service;
	
	@Test
	void contextLoads() {
		
		List<SchedulesDTO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(SchedulesDTO i:list) {
			System.out.println(i);
		}
		
	}

}