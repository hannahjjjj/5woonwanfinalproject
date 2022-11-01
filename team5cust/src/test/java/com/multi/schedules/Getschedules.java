package com.multi.schedules;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.SchedulesDTO;
import com.multi.service.SchedulesService;


@SpringBootTest
class Getschedules {

	@Autowired
	SchedulesService service;
	
	@Test
	void contextLoads() {
		SchedulesDTO schedules = null;
		try {
			schedules = service.get(100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(schedules);
	}

}




