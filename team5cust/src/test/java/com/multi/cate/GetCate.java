package com.multi.cate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CateDTO;
import com.multi.service.CateService;

@SpringBootTest
	class GetCate {
	
	@Autowired
	CateService service;
	
	@Test
	void contextLoads() {
		CateDTO cate = null;
		try {
			cate = service.get(10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cate);
		
	}

}
