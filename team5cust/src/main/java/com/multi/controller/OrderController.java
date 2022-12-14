package com.multi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustDTO;
import com.multi.dto.InstructorDTO;
import com.multi.dto.ItemDTO;
import com.multi.dto.OrdersDTO;
import com.multi.dto.ReviewDTO;
import com.multi.service.CustService;
import com.multi.service.CustbodyService;
import com.multi.service.InstructorService;
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
	
	@Autowired
	InstructorService inservice;
	
	@Autowired
	CustService cservice;
	
	@RequestMapping("/insertimpl")
	public String insertimpl(Model model,OrdersDTO order,String custid) {
		
		int itemid = order.getItemid();
		Date odate = order.getOdate();
		String itemname = order.getItem_name();
		int itemprice = order.getItem_price();
		int counting = order.getCounting();
		String instructorname = order.getInstructor_name();
		try {
			int instructorid = inservice.selectname(instructorname);
			OrdersDTO or = new OrdersDTO(1,itemid, custid,instructorid,0,odate,itemname,itemprice,counting,0,instructorname,null);
			oservice.register(or);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:orderdetail?id=" + order.getCustid();
	}
	
	
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
			model.addAttribute("list", list);
			model.addAttribute("center", "orderdetail");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return "index";
	}
	
	@RequestMapping("/insert")
	public String insert(Model model, int itemid, String custid, int instructorid,int facilityid) {
		ItemDTO list = null;
		CustDTO cust =null;
		InstructorDTO in = new InstructorDTO(0, 0, null, null, null, null, null, null, null);
		try {	
//			ItemDTO item = iservice.get(itemid);
//				itemid = item.getItemid();
//				item_name = item.getItemname();
//				price = item.getItemprice();
//				count = item.getCount();
//				instructor_name = item.getㅋ	Instructorname();
	//		OrdersDTO order = new OrdersDTO(0, itemid, id, day,item_name,price,count,instructor_name);
	//		oservice.register(order);
			list = iservice.get(itemid);
			if(instructorid==0) {
				in.setInstructorid(0);
			}else {
				in = inservice.get(instructorid);
			}
			int ordernum=oservice.getordernum();
			cust=cservice.get(custid);
			
			model.addAttribute("list", list);
			model.addAttribute("in", in);
			model.addAttribute("cust", cust);
			model.addAttribute("ordernum", ordernum+1);
			model.addAttribute("facilityid", facilityid);
			model.addAttribute("center", "insert");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "index";
	}
}
