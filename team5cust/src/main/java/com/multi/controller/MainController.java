package com.multi.controller;

import javax.servlet.http.HttpSession;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustDTO;
import com.multi.service.CustService;
import com.multi.dto.FacilityDTO;
import com.multi.service.FacilityService;
@Controller
public class MainController {	

	@Autowired
	CustService custservice;
	
	
	@Autowired
	FacilityService fservice;

	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("center", "index");
		return "redirect:/";
	}

	
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("center", "about");
		return "index";
	}
	@RequestMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("center", "contact");
		return "index";
	}
	
	//login 관련
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("status", "1");
		model.addAttribute("center", "login");
		return "index";
	}
	
	 @RequestMapping("/loginimpl")
	   public String loginimpl(String id, String pwd, Model model, HttpSession session) {   
	      CustDTO cust = null;
	      System.out.println(id+pwd);
	      try {
	         cust = custservice.get(id);
	         System.out.println(cust);
	         if(cust == null) {
	        	 model.addAttribute("status", "0");
	        	 model.addAttribute("center", "login");
	         } else {
	            if(pwd.equals(cust.getCustpwd())) {
	            	model.addAttribute("status", "1");
	               session.setAttribute("logincust", cust);
	               System.out.println("success");
	            } else {
	            	 model.addAttribute("status", "0");
	            	 model.addAttribute("center", "login");
	            	 }
	         }
	      } catch (Exception e) {      
	         e.printStackTrace();
	      }

	      return "index";
	   }
	 
	@RequestMapping("/agent")
	public String agent(Model model) {
		model.addAttribute("center", "agent");
		return "index";
	}
	
	@RequestMapping("/services")
	public String services(Model model) {
		model.addAttribute("center", "services");
		return "index";
	}
	
	   @RequestMapping("/facility")
	   public String facility(Model model) { 
		   List<FacilityDTO> list = null;
		  try {
			  list=fservice.get();
			  model.addAttribute("facilitylist",list);
			  model.addAttribute("center", "facility"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	      return "index";
	   }
	@RequestMapping("/blog")
	public String blog(Model model) {
		model.addAttribute("center", "blog");
		return "index";
	}
	
	@RequestMapping("/search")
	public String search(Model model) {
		model.addAttribute("center", "search");
		return "index";
	}
}











