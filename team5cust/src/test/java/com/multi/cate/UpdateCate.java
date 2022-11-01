package com.multi.cate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CateDTO;
import com.multi.service.CateService;

@SpringBootTest
	class UpdateCate {
	@Autowired
	CateService service;
	
	@Test
	void contextLoads() {
		CateDTO cate = new CateDTO(0,"필라테스");
		try {
			service.modify(cate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
