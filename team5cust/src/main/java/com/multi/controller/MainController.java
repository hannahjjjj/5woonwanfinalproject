package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {	
	
	@RequestMapping("/")
	public String main() {
		return "index";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("center","about");
		return "index";
	}
	
	@RequestMapping("/property")
	public String property(Model model) {
		model.addAttribute("center","property-list");
		return "index";
	}
	
	@RequestMapping("/propertytype")
	public String propertytype(Model model) {
		model.addAttribute("center","property-type");
		return "index";
	}
	
	@RequestMapping("/propertyagent")
	public String propertyagent(Model model) {
		model.addAttribute("center","property-agent");
		return "index";
	}
	
	@RequestMapping("/testimonial")
	public String testimonial(Model model) {
		model.addAttribute("center","testimonial");
		return "index";
	}
	
	@RequestMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("center","contact");
		return "index";
	}
	
	@RequestMapping("/404")
	public String fzf(Model model) {
		model.addAttribute("center","404");
		return "index";
	}
}









