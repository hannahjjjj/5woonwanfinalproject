package com.multi.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.AdminDTO;
import com.multi.service.AdminService;

@SpringBootTest
class InsertAdmin {

	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {
		
		AdminDTO admin= new AdminDTO("admin03", "apwd03", "이차장", "01011111111", "admin99@a.aa",1);
		
		try {
			service.register(admin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}