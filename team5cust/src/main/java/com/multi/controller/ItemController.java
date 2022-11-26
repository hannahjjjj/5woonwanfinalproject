package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	ItemService iservice;
	
	@RequestMapping("/item")
	public String item(Model model) {
		model.addAttribute("center", "item");
		return "index";
	}
}
