package com.multi.controller;

import javax.servlet.http.HttpSession;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.CustDTO;
import com.multi.service.CustService;
import com.multi.dto.FacilityDTO;
import com.multi.service.FacilityService;
@Controller
public class MainController {	

	@Autowired
	CustService custservice;
	
	
	@Autowired
	FacilityService fservice;

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
	               System.out.println("success");
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
			
			if(session != null) {
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
	public String search(Model model) {
		model.addAttribute("center", "search");
		return "index";
	}
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
	


	@RequestMapping("/custdetail")
	public String custdetail(Model model, String id) {
		CustDTO cust = null;
		try {
			cust = custservice.get(id);
			model.addAttribute("custdetail", cust);
			model.addAttribute("center","/cust/custdetail");
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
			model.addAttribute("custupdate", cust);
			model.addAttribute("center", "/cust/custupdate");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/custdelete")
	public String custdelete(Model model, String id) {
		CustDTO cust = null;
		try {
			cust = custservice.get(id);
			model.addAttribute("custdelete", cust);
			model.addAttribute("center", "/cust/custdelete");
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