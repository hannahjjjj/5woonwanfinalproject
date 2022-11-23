package com.multi.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.dto.CustDTO;
import com.multi.dto.FacilityDTO;
import com.multi.dto.SchedulesDTO;
import com.multi.service.CustService;
import com.multi.service.FacilityService;
import com.multi.service.SchedulesService;

@RestController
public class AJAXController {
	
	@Autowired
	CustService custservice;
	
	@Autowired
	FacilityService fservice;
	
	@Autowired
	SchedulesService schedulesService; 
	
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
	@RequestMapping("/naverlogin")
	public String naverlogin(String email,String name,String gender,String birthday,String birthyear,String mobile,HttpSession session) {
		
		CustDTO cust =new CustDTO(email, null, name, mobile, gender, birthyear+"-"+birthday, email, null, null, null, null, null, null, null);
		
		try {
			if(custservice.get(email)==null) {
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
	@RequestMapping("/schedulelist")
	public Object schedulelist(String selectday,String insid) {
		List<SchedulesDTO> list=null;
		JSONArray ja = new JSONArray();
		try {
			list=schedulesService.selectday(selectday,insid);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		//데이터 받아온거 시간으로 나눠서 넘겨주기.
		SimpleDateFormat sDate = new SimpleDateFormat("HH:mm");
		for(SchedulesDTO l:list) {
			ja.add(sDate.format(l.getStarttime()));
		}
		return ja;
	}

	@RequestMapping("/scheduletime")
	public Object scheduletime(String time,String id,String selectday,int insid) {
		String dateStr=selectday;
		dateStr+=" "+time;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date sDate;
		SchedulesDTO sc = null;
		try {
			sDate = formatter.parse(dateStr);
			sc= new SchedulesDTO(0, insid, id, sDate, null, 0);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			schedulesService.register(sc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//데이터 받아온거 시간으로 나눠서 넘겨주기.
		return "";
	}
}
