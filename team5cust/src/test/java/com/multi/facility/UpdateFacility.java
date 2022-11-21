package com.multi.facility;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CateDTO;
import com.multi.dto.FacilityDTO;
import com.multi.service.CateService;
import com.multi.service.FacilityService;

@SpringBootTest
	class UpdateFacility {
	@Autowired
	FacilityService service;
	

	@Test
	void contextLoads() {

		FacilityDTO facility = new FacilityDTO(100, 12, "gym헬스장","서울특별시 강남구 대치동 96","02)845-1645","b.jpg","am 09:00 - pm 08:00","am 09:00 - pm 08:00", 37.12, 128.54);
		try {
			service.modify(facility);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
