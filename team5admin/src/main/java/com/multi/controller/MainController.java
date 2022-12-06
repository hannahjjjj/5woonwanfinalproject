package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.AdminDTO;
import com.multi.service.AdminService;


@Controller
public class MainController {	

	@Autowired
	AdminService adminService;

	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("center", "index");
		return "redirect:/";
	}
	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("status", "1");
		model.addAttribute("center", "register");
		return "index";
	}
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model, AdminDTO admin) {
		try {
			adminService.register(admin);
			model.addAttribute("center","login");
			model.addAttribute("registatus", "1");
			
		} catch (Exception e) {
			model.addAttribute("center", "register");
			model.addAttribute("registatus", "0");
			e.printStackTrace();
		}
		
		return "index";
	}
	
	@RequestMapping("/general")
	public String general(Model model) {
		model.addAttribute("center", "general");
		return "index";
	}
	
	@RequestMapping("/buttons")
	public String buttons(Model model) {
		model.addAttribute("center", "buttons");
		return "index";
	}
	
	@RequestMapping("/panels")
	public String panels(Model model) {
		model.addAttribute("center", "panels");
		return "index";
	}
	
	@RequestMapping("/todo_list")
	public String todo_list(Model model) {
		model.addAttribute("center", "todo_list");
		return "index";
	}
	
	@RequestMapping("/calendar")
	public String calendar(Model model) {
		model.addAttribute("center", "calendar");
		return "index";
	}
	
	@RequestMapping("/gallery")
	public String gallery(Model model) {
		model.addAttribute("center", "gallery");
		return "index";
	}
	
	@RequestMapping("/blank")
	public String blank(Model model) {
		model.addAttribute("center", "blank");
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("status", "1");
		model.addAttribute("center", "login");
		return "index";
	}

	@RequestMapping("/logout")
	public String logout(Model model,HttpSession session) {
			
			if(session != null) {
				session.invalidate();
			}
			return "index";
}
	@RequestMapping("/loginimpl")
	public String loginimpl(String aid, String apwd, Model model, HttpSession session) {   
	      AdminDTO admin = null;
	      try {
	         admin = adminService.get(aid);
	         if(admin == null) {
	        	 model.addAttribute("status", "0");
	        	 model.addAttribute("center", "login");
	         } else {
	            if(apwd.equals(admin.getApwd())) {
	            	session.setAttribute("loginadmin", admin);
	            	model.addAttribute("status", "1");
	            	if(admin.getGrade()==2) {
	            		model.addAttribute("center", "maincenter2");
	            	}
	            	else if(admin.getGrade()==3) {
	            		model.addAttribute("center", "maincenter3");
	            	}
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
	
	
	
	@RequestMapping("/lock_screen")
	public String lock_screen(Model model) {
		model.addAttribute("center", "lock_screen");
		return "index";
	}
	
	@RequestMapping("/form_component")
	public String form_component(Model model) {
		model.addAttribute("center", "form_component");
		return "index";
	}
	
	@RequestMapping("/basic_table")
	public String basic_table(Model model) {
		model.addAttribute("center", "basic_table");
		return "index";
	}
	
	@RequestMapping("/responsive_table")
	public String responsive_table(Model model) {
		model.addAttribute("center", "responsive_table");
		return "index";
	}
	
	@RequestMapping("/morris")
	public String morris(Model model) {
		model.addAttribute("center", "morris");
		return "index";
	}
	
	@RequestMapping("/chartjs")
	public String chartjs(Model model) {
		model.addAttribute("center", "chartjs");
		return "index";
	}
}








