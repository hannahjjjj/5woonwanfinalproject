package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {	


	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("center", "index");
		return "redirect:/";
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
		model.addAttribute("center", "login");
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








