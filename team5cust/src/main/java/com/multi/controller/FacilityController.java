package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CateDTO;
import com.multi.dto.FacilityDTO;
import com.multi.dto.InstructorDTO;
import com.multi.service.CateService;
import com.multi.service.FacilityService;
import com.multi.service.InstructorService;

@Controller
public class FacilityController {
	@Autowired
	CateService cservice;
	@Autowired
	FacilityService fservice;
	@Autowired
	InstructorService iservice;
	

	
	@RequestMapping("/facility")
	public String facility(Model model,int cateid) {
		CateDTO cate = null;
		List<FacilityDTO> fac = null;
		
		try {
			cate = cservice.get(cateid);
			model.addAttribute("cate", cate);
			model.addAttribute("center","facility/health");
			fac = fservice.selectFacilityAll(cateid);
			model.addAttribute("facilitylist", fac);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/facilitydetail")
	public String facilitydetail(Model model,int facilityid) {
		FacilityDTO facility = null;
		List<CateDTO> list = null;
		List<FacilityDTO> fac = null;
		List<InstructorDTO> ins = null;
		try {
			facility = fservice.get(facilityid);
			list=cservice.viewCateName(facilityid);
			ins=iservice.selectFacilityList(facilityid);
			model.addAttribute("catelist",list);
			model.addAttribute("facilitydetail",facility);
			model.addAttribute("ins",ins);
			model.addAttribute("center","facility/facilitydetail");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return "index";
		
	}

	

}
