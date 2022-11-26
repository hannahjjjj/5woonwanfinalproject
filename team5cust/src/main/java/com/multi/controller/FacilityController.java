package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CateDTO;
import com.multi.dto.CustDTO;
import com.multi.dto.FacilityDTO;
import com.multi.dto.InstructorDTO;
import com.multi.dto.ReviewDTO;
import com.multi.mapper.FacilityMapper;
import com.multi.service.CateService;
import com.multi.service.FacilityService;
import com.multi.service.InstructorService;
import com.multi.service.ReviewService;

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
	ReviewService rservice;
	

	
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
	public String facilitydetail(Model model,int facilityid,HttpSession session) {
		FacilityDTO facility = null;
		List<CateDTO> list = null;
		List<FacilityDTO> fac = null;
		List<InstructorDTO> ins = null;
		CustDTO cust = (CustDTO) session.getAttribute("cust");
		List<ReviewDTO>rlist = null;
		try {
			facility = fservice.get(facilityid);
			list=cservice.viewCateName(facilityid);
			ins=iservice.selectFacilityList(facilityid);
			rlist=rservice.showtReview(facilityid);
			model.addAttribute("catelist",list);
			model.addAttribute("facilitydetail",facility);
			model.addAttribute("ins",ins);
			model.addAttribute("center","facility/facilitydetail");
			model.addAttribute("rlist",rlist);
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
		List<ReviewDTO> review = null;
		try {
			inst = iservice.get(instructorid);
			fac = fservice.viewFacilityName(instructorid);
			ins = iservice.selectInstructorList(instructorid);
			model.addAttribute("facilitylist",fac);
			model.addAttribute("ins",ins);
			model.addAttribute("instructordetail",inst);
			model.addAttribute("facilitydetail",facility);
			model.addAttribute("review",review);			
			model.addAttribute("center","facility/instructordetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/reviewimpl")
	public String reviewimpl(Model model, ReviewDTO review) {
		int reviewid = 0;
		try {
			reviewid = review.getFacilityid();
			rservice.register(review);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	

}
