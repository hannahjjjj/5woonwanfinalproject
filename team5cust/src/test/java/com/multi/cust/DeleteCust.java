package com.multi.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.CustService;

@SpringBootTest
class DeleteCust {

	@Autowired
	CustService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove("dbswlsgh1238");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DELETE OK");
	}
}