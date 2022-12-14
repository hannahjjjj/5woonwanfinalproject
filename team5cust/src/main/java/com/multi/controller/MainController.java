package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustDTO;
import com.multi.dto.CustbodyDTO;
import com.multi.dto.FacilityDTO;
import com.multi.dto.OrdersDTO;
import com.multi.dto.SchedulesDTO;
import com.multi.frame.ORCUtil;
import com.multi.frame.Util;
import com.multi.mapper.FacilityMapper;
import com.multi.service.CustService;
import com.multi.service.CustbodyService;
import com.multi.service.FacilityService;
import com.multi.service.OrdersService;
import com.multi.service.SchedulesService;

@Controller
public class MainController {	

	@Autowired
	CustService custservice;
	
	@Autowired
	OrdersService orderservice;
	
	@Autowired
	FacilityService fservice;
	
	@Autowired
	SchedulesService scuedulesservice;

	@Autowired
	CustbodyService custbodyservice;
	
	@Autowired
	FacilityMapper fmapper;
	
	@Value("${admindir}")
	String admindir;

	@Value("${custdir}")
	String custdir;
	

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
	      try {
	         cust = custservice.get(id);
	         if(cust == null) {
	        	 model.addAttribute("status", "0");
	        	 model.addAttribute("center", "login");
	         } else {
	            if(pwd.equals(cust.getCustpwd())) {
	            	model.addAttribute("status", "1");
	               session.setAttribute("logincust", cust);
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

	@RequestMapping("/logout")
	public String logout(Model model,HttpSession session) {
			System.out.println(session);
			if(session != null) {
				System.out.println("이거탐?");
				session.invalidate();
			}
			return "index";
		}
	 
	// login 관련 end

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
	
	@RequestMapping("/blog")
	public String blog(Model model) {
		model.addAttribute("center", "blog");
		return "index";
	}
	
	@RequestMapping("/blog-single")
	public String blogsingle(Model model) {
		model.addAttribute("center", "blog-single");
		return "index";
	}
	
	@RequestMapping("/search")
	public String search(Model model, String txt) {
		List<FacilityDTO> list=null;		 
		try {
			list=fmapper.searchFacility(txt);
			model.addAttribute("facilitylist",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
			model.addAttribute("center","search");
			System.out.println(txt);
			return "index";
	}
	
	// 회원가입
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("center", "register");
		model.addAttribute("registatus", "1");
		return "index";
	}
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model, CustDTO cust) {
//		System.out.println(cust);
		try {
			custservice.register(cust);
			model.addAttribute("center","login");
			model.addAttribute("registatus", "1");
			
		} catch (Exception e) {
			model.addAttribute("center", "register");
			model.addAttribute("registatus", "0");
			e.printStackTrace();
		}
		
		return "index";
	}
	//회원가입 end
	
	@RequestMapping("/mypage")
	public String mypage(Model model, String id) {
		CustDTO cust = null;
		try {
			cust = custservice.get(id);
			model.addAttribute("custdetail", cust);
			model.addAttribute("center","/cust/mypage");
			model.addAttribute("custcenter","/cust/custdetail");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/custupdate")
	public String custupdate(Model model, String id) {
		CustDTO cust = null;
		try {
			cust = custservice.get(id);
			model.addAttribute("custdetail", cust);
			model.addAttribute("center","/cust/mypage");
			model.addAttribute("custcenter","/cust/custupdate");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	// 마이 페이지 내에 개인 스케줄 
	
	@RequestMapping("/custschedule")
	public String custschedule(Model model, String id, String insid) {
		CustDTO cust = null;
		try {
			cust = custservice.get(id);
			model.addAttribute("custdetail", cust);
			model.addAttribute("insid", insid);
			model.addAttribute("center","/cust/mypage");
			model.addAttribute("custcenter", "/cust/custschedule");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/custorderlist")
	public String custorderlist(Model model, String id) {
		CustDTO cust = null;
		List<OrdersDTO> order = null;
		List<SchedulesDTO> schedules=null;
		try {
			cust = custservice.get(id);
			order = orderservice.mymembership(id);
			schedules=scuedulesservice.myschedulsestatus(id);
			model.addAttribute("custdetail", cust);
			model.addAttribute("orderlist", order);
			model.addAttribute("center","/cust/mypage");
			model.addAttribute("custcenter", "/cust/custorderlist");
			model.addAttribute("schedulesstatus", schedules);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	// 개인 스케줄 end
	
	// ocr 및 정보 변화
	@RequestMapping("/ocrdata")
	public String ocrdata(String bodyfat,String weight,String muscle,Model model) {
		
		model.addAttribute("bodyfat", bodyfat);
		model.addAttribute("weight", weight);
		model.addAttribute("muscle", muscle);
		model.addAttribute("modalflag", "0");
		return "cust/ocrdata";
	}
	
	@RequestMapping("/mychange")
	public String mychange(Model model, String id) {
		CustDTO cust = null;

		try {
			cust = custservice.get(id);
			model.addAttribute("custdetail", cust);
			model.addAttribute("center","/cust/mypage");
			model.addAttribute("custcenter", "/cust/mychange");
			model.addAttribute("modalflag", "0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/mydatainput")
	public String mydatainput(Model model, String id,String weight,String muscle, String bodyfat) {
		double bf=Double.parseDouble(bodyfat);
		double mc=Double.parseDouble(muscle);
		double wg=Double.parseDouble(weight);
	
		model.addAttribute("bodyfat", bodyfat);
		model.addAttribute("weight", weight);
		model.addAttribute("muscle", muscle);
		model.addAttribute("modalflag","1");
		
		CustbodyDTO custbody= new CustbodyDTO(0, id, null, 0, bf, mc, wg, null, null);
		try {
			custbodyservice.register(custbody);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "cust/ocrdata";
	}
	
	

	@RequestMapping("/ocrimpl")
	public String ocrimpl(Model model, CustbodyDTO obj) {
		CustDTO cust = null;
		String imgname = obj.getImg().getOriginalFilename(); // 파일덩어리 안에있는 파일이름을 꺼낸다.
		CustbodyDTO custbody=null;
		
		obj.setImgname(imgname);
		try {
			Util.saveFile(obj.getImg(), admindir, custdir); // 이미지 덩어리를 관리자 디렉, 사용자 디렉에 저장
			String result = ORCUtil.getText(imgname);
			
			JSONParser jsonparser = new JSONParser();
			JSONObject jo = (JSONObject) jsonparser.parse(result);

			JSONArray ja1 = (JSONArray) jo.get("images");
			JSONObject jo1 = (JSONObject) ja1.get(0);
			JSONArray ja2 = (JSONArray) jo1.get("fields");

			JSONObject f1 = (JSONObject) ja2.get(0);
			JSONObject f2 = (JSONObject) ja2.get(1);
			JSONObject f3 = (JSONObject) ja2.get(2);

			String bodyfat = (String) f1.get("inferText");
			String weight= (String) f2.get("inferText");
			String muscle = (String) f3.get("inferText");

			model.addAttribute("bodyfat", bodyfat);
			model.addAttribute("weight", weight);
			model.addAttribute("muscle", muscle);
			
			cust = custservice.get(obj.getCustid());
			model.addAttribute("custdetail", cust);
			
			 model.addAttribute("center","/cust/mypage");
			 model.addAttribute("custcenter","/cust/mychange");
			 
			model.addAttribute("modalflag", "1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	// ocr 및 정보 변화 end
	
	
	@RequestMapping("/custdelete")
	public String custdelete(Model model, String id) {
		CustDTO cust = null;
		try {
			cust = custservice.get(id);
			model.addAttribute("custdetail", cust);
			model.addAttribute("center", "/cust/mypage");
			model.addAttribute("custcenter", "/cust/custdelete");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/custupdateimpl")
	public String custupdateimpl(Model model, CustDTO cust, HttpSession session) {
		try {
			custservice.modify(cust);
			session.setAttribute("logincust", cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:custdetail?id="+cust.getCustid();
	}
	
	@RequestMapping("/custdeleteimpl")
	public String custdeleteimpl(Model model, String custid,HttpSession session) {
		try {
			custservice.remove(custid);
			if(session != null) {
				session.invalidate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:";
	}
	
}


//	   @RequestMapping("/facility")
//	   public String facility(Model model) { 
//		   List<FacilityDTO> list = null;
//		  try {
//			  list=fservice.get();
//			  model.addAttribute("facilitylist",list);
//			  model.addAttribute("center", "facility"); 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	      return "index";
//	   }