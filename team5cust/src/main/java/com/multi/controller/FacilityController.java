package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CateDTO;
import com.multi.dto.CustDTO;
import com.multi.dto.FacilityDTO;
import com.multi.dto.FacilityPage;
import com.multi.dto.InstructorDTO;
import com.multi.dto.ItemDTO;
import com.multi.dto.ReviewDTO;
import com.multi.mapper.FacilityMapper;
import com.multi.mapper.ItemMapper;
import com.multi.service.CateService;
import com.multi.service.FacilityService;
import com.multi.service.InstructorService;
import com.multi.service.ItemService;
import com.multi.service.ReviewService;

@Controller
public class FacilityController {
	@Autowired
	CateService cservice;
	@Autowired
	FacilityService fservice;
	@Autowired
	InstructorService iservice;
	@Autowired
	FacilityMapper fmapper;
	@Autowired
	ReviewService rservice;
	@Autowired
	ItemService itservice;
	
	@Autowired
	ItemMapper mapper;
	
	@Value("9")
	private int amount;
	
	@ModelAttribute("amount")
	public int addAmount() {
		return amount;
	}

	
	/*
	 * @RequestMapping("/facility") public String main(Model m, Integer pageNo, int
	 * cateid) {
	 * 
	 * if(pageNo == null) { pageNo = 1; }
	 * 
	 * int startIndex = amount * (pageNo - 1); int endIndex = 0; int cnt = 0;
	 * 
	 * try { List<FacilityDTO> list = fservice.selectFacilityAll(cateid); cnt =
	 * list.size();
	 * 
	 * if(cnt - startIndex < amount) { endIndex = startIndex + (cnt % amount); }else
	 * { endIndex = startIndex + amount; }
	 * 
	 * list = list.subList(startIndex, endIndex); m.addAttribute("facilitylist",
	 * list); } catch (Exception e) { e.printStackTrace(); };
	 * m.addAttribute("currentPage", pageNo);
	 * 
	 * return "index"; }
	 */
	
	@RequestMapping("/facility")
	public String facility(Model model,int cateid,Integer pageNo) {
		CateDTO cate = null;
		List<FacilityDTO> fac = null;
		if(pageNo == null) {
			pageNo = 1;
		}
		
		int startIndex = amount * (pageNo - 1);
		int endIndex = 0;
		int cnt = 0;
		
		try {
			cate = cservice.get(cateid);
			model.addAttribute("cate", cate);
			fac = fservice.selectFacilityAll(cateid);
			cnt=fac.size();
			
			if(cnt - startIndex < amount) {
				endIndex = startIndex + (cnt % amount);
			}else {
				endIndex =  startIndex + amount;
			}
			
			fac = fac.subList(startIndex, endIndex);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("list", fac);
		model.addAttribute("center","facility/health");
		model.addAttribute("totalData", cnt);
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("facilitylist", "facility/facilitylist");
		model.addAttribute("amount", amount);
		return "index";
	}
	
	@RequestMapping("facility/facilitypage")
	public String findPage(Model model, int pageNo, int cateid) {
		List<FacilityDTO> fac = null;
		CateDTO cate = null;
		int startIndex = amount * (pageNo - 1);
		int endIndex = 0;
		int cnt = 0;
		
		try {
			cate = cservice.get(cateid);
			fac = fservice.selectFacilityAll(cateid);
			cnt = fac.size();
			if(cnt - startIndex < amount) {
				endIndex = startIndex + (cnt % amount);
			}else {
				endIndex =  startIndex + amount;
			}
			fac = fac.subList(startIndex, endIndex);
			model.addAttribute("list", fac);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalData", cnt);
		model.addAttribute("cate", cate);
		
		return "facility/facilitylist";
	}
	
	@RequestMapping("/facilitydetail")
	public String facilitydetail(Model model,int facilityid,HttpSession session) {
		ItemDTO item = null;
		FacilityDTO facility = null;
		List<CateDTO> list = null;
		List<FacilityDTO> fac = null;
		List<InstructorDTO> ins = null;
		List<ItemDTO> it = null;
		CustDTO cust = (CustDTO) session.getAttribute("cust");
		List<ReviewDTO>rlist = null;
		try {
			item = itservice.get(facilityid);
			facility = fservice.get(facilityid);
			list=cservice.viewCateName(facilityid);
			ins=iservice.selectFacilityList(facilityid);
			rlist=rservice.showtReview(facilityid);
			it = itservice.selectfacilityList(facilityid);
			model.addAttribute("catelist",list);
			model.addAttribute("facilitydetail",facility);
			model.addAttribute("ins",ins);
			model.addAttribute("itemlist",it);
			model.addAttribute("center","facility/facilitydetail");
			model.addAttribute("rlist",rlist);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return "index";
		
	}
	
	@RequestMapping("/instructordetail")
	public String instructordetail(Model model,int instructorid) {
		ItemDTO item = null;
		InstructorDTO inst = null;
		FacilityDTO facility = null;
		List<ItemDTO> list1 = null;
		List<FacilityDTO> fac = null;	
		List<InstructorDTO> ins = null;
		List<ReviewDTO> review = null;
		try {
			item = itservice.get(instructorid);
			inst = iservice.get(instructorid);
			list1 = itservice.selectItemList(instructorid);
			System.out.println(list1);
			fac = fservice.viewFacilityName(instructorid);
			ins = iservice.selectInstructorList(instructorid);
			model.addAttribute("instructordetail",item);
			model.addAttribute("instructordetail",inst);
			model.addAttribute("facilitydetail",facility);
			model.addAttribute("review",review);			
			model.addAttribute("list1",list1);
			model.addAttribute("facilitylist",fac);
			model.addAttribute("ins",ins);
			model.addAttribute("center","facility/instructordetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/reviewimpl")
	public String reviewimpl(Model model, ReviewDTO review) {
			try {
				rservice.register(review);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return "index";
	}
	
}

	

