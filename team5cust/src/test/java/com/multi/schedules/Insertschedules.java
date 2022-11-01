package com.multi.schedules;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.SchedulesDTO;
import com.multi.service.SchedulesService;


@SpringBootTest
class Insertschedules {

	@Autowired
	SchedulesService service;
	
	@Test
	void contextLoads() {
		Date today=new Date();
        
		SchedulesDTO schedules = new SchedulesDTO(100,100,"dbswlsgh",today,today,3);
		
		try {
			service.register(schedules);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}




