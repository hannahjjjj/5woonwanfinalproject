package com.multi.custbody.copy;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CustbodyDTO;
import com.multi.service.CustbodyService;

@SpringBootTest
class GetAllCustbody {

	@Autowired
	CustbodyService service;
	
	@Test
	void contextLoads() {
		List<CustbodyDTO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(CustbodyDTO c:list) {
			System.out.println(c);
		}
	}

}




