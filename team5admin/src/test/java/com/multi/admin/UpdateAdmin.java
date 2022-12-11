package com.multi.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.AdminDTO;
import com.multi.service.AdminService;

@SpringBootTest
class UpdateAdmin {

	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {

		//AdminDTO admin = new AdminDTO("admin01","pwd01","김부사장","01099999999","admin@a.aa",1);
		try {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("UPDATE OK");
	}

}