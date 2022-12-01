package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.ItemDTO;
import com.multi.mapper.ItemMapper;
import com.multi.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	ItemService iservice;
	
	@Autowired
	ItemMapper mapper;
	
	@RequestMapping("/item")
	public String item(Model model, Integer itemid, Integer cateid) {
		List<ItemDTO> list = null;
		List<ItemDTO> list1 = null;
		List<ItemDTO> list2 = null;
		
		try {
			list = mapper.itemList(cateid);
			model.addAttribute("list1",list);
			cateid = 20;
			list1 = mapper.itemList(cateid);
			model.addAttribute("list2",list1);
			cateid = 30;
			list2 = mapper.itemList(cateid);
			model.addAttribute("list2",list2);
			model.addAttribute("center", "item");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "index";
	}
	
}
