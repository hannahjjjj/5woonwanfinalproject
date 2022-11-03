package com.multi.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CustDTO;
import com.multi.service.CustService;

@SpringBootTest
class GetCust {

	@Autowired
	CustService service;
	
	@Test
	void contextLoads() {
		CustDTO cust = null;
		try {
			cust = service.get("dbswlsgh1238");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cust);
	}

}




