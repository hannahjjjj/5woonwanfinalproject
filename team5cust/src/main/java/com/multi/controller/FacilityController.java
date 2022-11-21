package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CateDTO;
import com.multi.dto.FacilityDTO;
import com.multi.dto.InstructorDTO;
import com.multi.mapper.FacilityMapper;
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
	@Autowired
	FacilityMapper fmapper;
	

	
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
	
	@RequestMapping("/instructordetail")
	public String instructordetail(Model model,int instructorid) {
		InstructorDTO inst = null;
		FacilityDTO facility = null;
		List<FacilityDTO> fac = null;	
		List<InstructorDTO> ins = null;
		try {
			inst = iservice.get(instructorid);
			fac = fservice.viewFacilityName(instructorid);
			ins = iservice.selectInstructorList(instructorid);
			model.addAttribute("facilitylist",fac);
			model.addAttribute("ins",ins);
			model.addAttribute("instructordetail",inst);
			model.addAttribute("facilitydetail",facility);
			model.addAttribute("center","facility/instructordetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/search2")
	public String searchFacility(Model model, String txt) {
		List<FacilityDTO>fac=null;
		try {
			fac=fmapper.searchFacility(txt);
			model.addAttribute("fac",fac);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("center","search");
		
		return"index";
	}

}
