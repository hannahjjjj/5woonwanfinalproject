package com.multi.custbody.copy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CustbodyDTO;
import com.multi.service.CustbodyService;

@SpringBootTest
class DeleteCustbody {

	@Autowired
	CustbodyService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DELETE OK");
	}
}