package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CateDTO;
import com.multi.dto.FacilityDTO;
import com.multi.service.CateService;
import com.multi.service.FacilityService;

@Controller
public class FacilityController {
	@Autowired
	CateService cservice;
	@Autowired
	FacilityService fservice;
	
	@RequestMapping("/health")
	public String health(Model model,int cateid) {
		CateDTO cate = null;
		List<FacilityDTO> fac = null;
		try {
			cate = cservice.get(10);
			model.addAttribute("cate", cate);
			fac = fservice.selectFacilityAll(cateid);
			model.addAttribute("fl", fac);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	

}
