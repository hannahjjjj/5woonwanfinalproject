package com.multi.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.dto.CustDTO;
import com.multi.service.CustService;

@RestController
public class AJAXController {
	
	@Autowired
	CustService custservice;
	
	@RequestMapping("/kakkologin")
	public String kakkologin(String id,String name,String birthday,String email,String gender,HttpSession session) {
		name=name.substring(1, name.length()-1);
		birthday=birthday.substring(1, birthday.length()-1);
		email=email.substring(1, email.length()-1);
		gender=gender.substring(1, gender.length()-1);
		
		CustDTO cust =new CustDTO(email, null, name, null, gender, null, email, null, null, email, null, null, null, id);
		
		try {
			if(custservice.selectkakkoid(id)==null) {
				custservice.register(cust);
				session.setAttribute("logincust", cust);
			}else {
				session.setAttribute("logincust", cust);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
