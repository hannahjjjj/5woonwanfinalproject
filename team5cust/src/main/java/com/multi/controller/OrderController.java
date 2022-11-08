package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.OrdersDTO;
import com.multi.dto.ReviewDTO;
import com.multi.service.ItemService;
import com.multi.service.OrdersService;
import com.multi.service.ReviewService;

@Controller
public class OrderController {

	@Autowired
	ItemService iservice;
	
	@Autowired
	ReviewService rservice;
	
	@Autowired
	OrdersService oservice;
	
	
	@RequestMapping("/orderdetail")
	public String orderdetail(Model model,String id, ReviewDTO re) {
		List<OrdersDTO> list = null;
		
		try {

//			rservice.register(re);
//			int i = re.getReviewid();
//			model.addAttribute("list", i);
//			model.addAttribute("center", "review/insert");
//
//			list = iservice.get();
			list = oservice.orderall(id);
			System.out.println(list);
			model.addAttribute("list", list);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		model.addAttribute("center", "orderdetail");
		return "index";
	}
	
	
}
