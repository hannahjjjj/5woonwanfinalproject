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
import com.multi.dto.CustbodyDTO;
import com.multi.dto.FacilityDTO;
import com.multi.dto.InstructorDTO;
import com.multi.dto.ItemDTO;
import com.multi.dto.OrdersDTO;
import com.multi.dto.SchedulesDTO;
import com.multi.service.CustService;
import com.multi.service.CustbodyService;
import com.multi.service.FacilityService;
import com.multi.service.InstructorService;
import com.multi.service.ItemService;
import com.multi.service.OrdersService;
import com.multi.service.ReviewService;
import com.multi.service.SchedulesService;

@RestController
public class AJAXController {
	
	@Autowired
	CustService custservice;
	
	@Autowired
	FacilityService fservice;
	
	@Autowired
	SchedulesService schedulesService; 
	
	@Autowired
	CustbodyService custbodyservice;
	
	@Autowired
	ReviewService rservice;
	
	@Autowired
	OrdersService oservice;
	
	@Autowired
	InstructorService insservice;
	
	@Autowired
	ItemService itemservice;

	@RequestMapping("/checkid")
	public Object checkid(String cid) {
		String result = "";
		CustDTO cust = null;
		try {
			cust = custservice.get(cid);
			if(cust!=null) {
				result="f";
			}else {
				result="t";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
		}
	
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
		SchedulesDTO sc1 = null;
		try {
			sDate = formatter.parse(dateStr);
			sc1= new SchedulesDTO(0, insid, id, sDate, null, null, 0, null, null, null, 0, null);
			
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
	
	@RequestMapping("/mychangedata")
	public Object mychangedata(String id) {
		List<CustbodyDTO> list =null;
		JSONObject result = new JSONObject();
        JSONArray ja = new JSONArray();
        
        JSONObject bodyfat = new JSONObject();
        JSONObject weight = new JSONObject();
        JSONObject muscle = new JSONObject();
        
        JSONArray bodyfatja = new JSONArray();
        JSONArray wieghtja = new JSONArray();
        JSONArray muscleja = new JSONArray();
        
        JSONArray date = new JSONArray();
		try {
			list=custbodyservice.custbodylatest(id);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //차트 형식에 맞게 데이터 넣기
        SimpleDateFormat sDate = new SimpleDateFormat("YYYY-MM-dd");
        for(CustbodyDTO c:list) {
        	date.add(sDate.format(c.getBdate()));
        	bodyfatja.add(c.getBodyfat());
        	wieghtja.add(c.getWeight());
        	muscleja.add(c.getMuscle());
        }
        result.put("date", date);
        
        bodyfat.put("data", bodyfatja);
        weight.put("data", wieghtja);
        muscle.put("data", muscleja);
        
        bodyfat.put("name", "Bodyfat");
        weight.put("name", "Weight");
        muscle.put("name", "Muscle");
        
        ja.add(bodyfat);
        ja.add(weight);
        ja.add(muscle);
        
        result.put("result", ja);
		
		return result;
	}
	

	@RequestMapping("/checkorder") //리뷰작성용
		public String checkorder(String custid, int facilityid) {
			int orderid=0;
			String orderid1 = Integer.toString(orderid);
			String result = null;
			try {
				orderid1 = oservice.checkorder(custid, facilityid);
				if(orderid1 != null) {
					result="1";
				}else {
					result="0";
				}

			} catch (Exception e) {		
				e.printStackTrace();
			}
			return result;
		}
	
	@RequestMapping("/order") 
	public String order(String custid, int itemid,int instructorid,int facilityid) {
			try {
				OrdersDTO orders =new OrdersDTO(0, itemid, custid, instructorid, facilityid, null, null, 0, 0, 0, null, null);
				oservice.register(orders);
				/*
				 * fac=fservice. OrdersDTO orders=new OrdersDTO(0, itemid, custid, instructorid,
				 * ins.getFacilityid(), null, item.getItemname(),item.getItemprice() ,
				 * item.getCounting(), item.getPeriod(), ins.getInstructorname(), facilityname);
				 */			
				} catch (Exception e) {		
				}
				return "";
	}

}
