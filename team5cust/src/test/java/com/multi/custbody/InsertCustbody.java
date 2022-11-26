package com.multi.custbody;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CustbodyDTO;
import com.multi.service.CustbodyService;

@SpringBootTest
class InsertCustbody {

	@Autowired
	CustbodyService service;
	
	@Test
	void contextLoads() {
		
		CustbodyDTO custbody= new CustbodyDTO(0, null, null, 0, 0, 0, 0, null, null);
		
		try {
			service.register(custbody);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}