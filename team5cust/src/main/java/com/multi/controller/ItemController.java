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
	public String item(Model model, Integer itemid) {
		List<ItemDTO> list1 = null;
		List<ItemDTO> list2 = null;
		List<ItemDTO> list3 = null;
		List<ItemDTO> list4 = null;
		try {
			list1 = mapper.selecttype1();
			list2 = mapper.selecttype2();
			list3 = mapper.selecttype3();
			list4 = mapper.selecttype4();
			model.addAttribute("list1",list1);
			model.addAttribute("list2",list2);
			model.addAttribute("list3",list3);
			model.addAttribute("list4",list4);
			model.addAttribute("center", "item");
			System.out.println(list1);
			System.out.println(list2);
			System.out.println(list3);
			System.out.println(list4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "index";
	}
	
}
