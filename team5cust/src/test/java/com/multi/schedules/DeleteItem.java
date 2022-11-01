package com.multi.schedules;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.SchedulesService;

@SpringBootTest
class DeleteItem {
	
	@Autowired
	SchedulesService service;
	
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
