package com.multi.custbody.copy;

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
		
		CustbodyDTO custbody= new CustbodyDTO(10, "id02", null, 0, 0, 0, 186);
		
		try {
			service.register(custbody);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}