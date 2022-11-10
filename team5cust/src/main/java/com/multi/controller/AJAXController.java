package com.multi.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.dto.CustDTO;
import com.multi.dto.FacilityDTO;
import com.multi.service.CustService;
import com.multi.service.FacilityService;

@RestController
public class AJAXController {
	
	@Autowired
	CustService custservice;
	
	@Autowired
	FacilityService fservice;
	
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
	
	@RequestMapping("/marker")
	public Object marker(int facilityid) {
		FacilityDTO fac = null;
		JSONArray ja = new JSONArray();
		JSONObject jo = new JSONObject();
		try {
			fac=fservice.get(facilityid);
			double flat=fac.getLat();
			double flng=fac.getLng();
			jo.put("lat", flat);
			jo.put("lng", flng);
			ja.add(jo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ja;
	}
}
