package com.multi.controller;


import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.dto.AdminDTO;
import com.multi.service.AdminService;

@RestController
public class AJAXController {
	
	@Autowired
	AdminService adminservice;
	
	@RequestMapping("/genderratio")
	public Object genderratio(String id) {
		return "";
	}
	@RequestMapping("/newcust")
	public Object newcust(String id) {
		JSONObject result = new JSONObject();
        JSONArray ja = new JSONArray();
        JSONObject newcust = new JSONObject();
        JSONArray newcustja = new JSONArray();
        JSONArray date = new JSONArray();
		
        List<AdminDTO> list=null;
        try {
        	list=adminservice.newcust(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for(AdminDTO c:list) {
        	date.add(c.getOdate());
        	newcustja.add(c.getCust_count());
        }
        newcust.put("name", "New Customer Count");
        newcust.put("data", newcustja);
        
        ja.add(newcust);
        
        result.put("date", date);
		result.put("result", ja);
		return result;
	}
	
	@RequestMapping("/myprofit")
	public Object myprofit(String id) {
		JSONObject result = new JSONObject();
        JSONArray ja = new JSONArray();
        JSONObject profit = new JSONObject();
        JSONArray profitja = new JSONArray();
        JSONArray date = new JSONArray();
		
        List<AdminDTO> list=null;
        try {
        	list=adminservice.myprofit(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for(AdminDTO c:list) {
        	date.add(c.getOdate());
        	profitja.add(c.getProfit());
        }
        profit.put("name", "profit");
        profit.put("data", profitja);
        
        ja.add(profit);
        
        result.put("date", date);
		result.put("result", ja);
		return result;
	}
}
