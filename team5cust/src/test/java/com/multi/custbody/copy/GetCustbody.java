package com.multi.custbody.copy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CustbodyDTO;
import com.multi.service.CustbodyService;

@SpringBootTest
class GetCustbody {

	@Autowired
	CustbodyService service;
	
	@Test
	void contextLoads() {
		CustbodyDTO custbody = null;
		try {
			custbody = service.get(4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(custbody);
	}

}




