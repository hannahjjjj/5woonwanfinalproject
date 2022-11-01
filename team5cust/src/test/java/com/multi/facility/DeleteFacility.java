package com.multi.facility;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.FacilityService;

@SpringBootTest
	class DeleteFacility {
	
	@Autowired
	FacilityService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(101);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
