package com.multi.facility;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CateDTO;
import com.multi.dto.FacilityDTO;
import com.multi.service.CateService;
import com.multi.service.FacilityService;

@SpringBootTest
	class GetFacility {
	@Autowired
	FacilityService service;
	

	@Test
	void contextLoads() {
		FacilityDTO facility = null;
		try {
			facility = service.get(100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(facility);
	}



}
