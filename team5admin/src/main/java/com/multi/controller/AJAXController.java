package com.multi.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.dto.AdminDTO;
import com.multi.dto.SchedulesDTO;
import com.multi.service.AdminService;
import com.multi.service.SchedulesService;

@RestController
public class AJAXController {

	@Autowired
	AdminService adminservice;
	
	@Autowired
	SchedulesService schedulesService; 
	
	// 시설 관리자 
	@RequestMapping("/genderratio")
	public Object genderratio(String id) {
		JSONObject result = new JSONObject();
		JSONArray ja = new JSONArray();
		JSONObject male = new JSONObject();
		JSONObject female = new JSONObject();
		JSONArray maleja = new JSONArray();
		JSONArray femaleja = new JSONArray();
		JSONArray age = new JSONArray();
		int[] arrmale = {0,0,0,0,0,0};
		int[] arrfemale = {0,0,0,0,0,0};
		String strgender;
		String strage;

				
		List<AdminDTO> list = null;
		try {
			list = adminservice.genderratio(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//연령대 별 카운트 넣어주기 ... 다른 방법이 생각이 나지않아요
		for (int j = 0; j < list.size(); j++) {
			strage = list.get(j).getAge_group();
			strgender=list.get(j).getGender();
			switch (strage) {
			case "10대":
				if(strgender.equals("male")) {
					arrmale[0]++;
				}
				else {
					arrfemale[0]++;
				}
				break;
			case "20대":
				if(strgender.equals("male")) {
					arrmale[1]++;
				}
				else {
					arrfemale[1]++;
				}
				break;
			case "30대":
				if(strgender.equals("male")) {
					arrmale[2]++;
				}
				else {
					arrfemale[2]++;
				}
				break;
			case "40대":
				if(strgender.equals("male")) {
					arrmale[3]++;
				}
				else {
					arrfemale[3]++;
				}
				break;
			case "50대":
				if(strgender.equals("male")) {
					arrmale[4]++;
				}
				else {
					arrfemale[4]++;
				}
				break;
			case "60대 이상":
				if(strgender.equals("male")) {
					arrmale[5]++;
				}
				else {
					arrfemale[5]++;
				}
				break;
			}
		}
		
		//y축
		male.put("name", "male");
		female.put("name", "female");
		for(int i:arrmale) {
			maleja.add(i);
		}
		for(int i:arrfemale) {
			femaleja.add(i);
		}
		male.put("data", maleja);
		female.put("data", femaleja);
		ja.add(male);
		ja.add(female);
		result.put("result", ja);
		//x축 
		age.add("10대");
		age.add("20대");
		age.add("30대");
		age.add("40대");
		age.add("50대");
		age.add("60대 이상");
		result.put("age", age);
		
		return result;
	}

	@RequestMapping("/newcust")
	public Object newcust(String id) {
		JSONObject result = new JSONObject();
		JSONArray ja = new JSONArray();
		JSONObject newcust = new JSONObject();
		JSONArray newcustja = new JSONArray();
		JSONArray date = new JSONArray();

		List<AdminDTO> list = null;
		try {
			list = adminservice.newcust(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (AdminDTO c : list) {
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

		List<AdminDTO> list = null;
		try {
			list = adminservice.myprofit(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (AdminDTO c : list) {
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
	 @RequestMapping("/schedulelist")
	 public Object schedulelist(String id,String selectday,Model model) {
		 List<SchedulesDTO> list = null;
		 
		 try {
			list=schedulesService.selectdayadmin(selectday, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("adminschedulelist", list);
		 return list;
	 }
	
}
