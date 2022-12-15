package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.AdminDTO;
import com.multi.dto.CateDTO;
import com.multi.dto.FacilityDTO;
import com.multi.dto.InstructorDTO;
import com.multi.mapper.FacilityMapper;
import com.multi.service.AdminService;
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

	@Autowired
	AdminService aservice;
	@RequestMapping("/facilit_update")
	public String facility_update(Model model,int facilityid,HttpSession session) {

		
		try {
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		model.addAttribute("center","facility/facility_update");
		return "index";
		
	}
	
	@RequestMapping("/instructorupdate")
	public String instructorupdate(Model model, InstructorDTO ins, int instructorid) {

		try {

			iservice.modify(ins);
			ins = iservice.get(instructorid);
			System.out.println(ins);
			model.addAttribute("i",ins);
			model.addAttribute("center", "facility/facilitydetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:facilitydetail?facilityid=" + ins.getFacilityid();
	}
	
	@RequestMapping("/instructordelete")
	public String instructordelete(Model model, int instructorid) {
		InstructorDTO ins = null;
		try {
			ins = iservice.get(instructorid);
			iservice.remove(instructorid);
			aservice.deleteins(instructorid);
			model.addAttribute("center", "facility/facilitydetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:facilitydetail?facilityid=" + ins.getFacilityid();
	}
	
	
	@RequestMapping("/facilitydetail")
	public String facilitydetail(Model model,int facilityid,HttpSession session) {
		List<InstructorDTO> ins = null;
		AdminDTO admin = (AdminDTO) session.getAttribute("admin");
		try {

			ins=iservice.selectFacilityList(facilityid);

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

			model.addAttribute("instructordetail",inst);
			model.addAttribute("facilitydetail",facility);
			model.addAttribute("facilitylist",fac);
			model.addAttribute("ins",ins);
			model.addAttribute("center","facility/instructordetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	
}

	

