package com.multi.facility;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.FacilityDTO;
import com.multi.service.FacilityService;

@SpringBootTest
	class GetAllFacility {
	@Autowired
	FacilityService service;
	

	@Test
	void contextLoads() {
		List<FacilityDTO> list = null;
		try {
			list=service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(FacilityDTO f:list) {
			System.out.println(f);
		}
		
	}



}
