package com.multi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.AdminDTO;
import com.multi.dto.FacilityDTO;
import com.multi.dto.InstructorDTO;
import com.multi.dto.SchedulesDTO;
import com.multi.service.AdminService;
import com.multi.service.FacilityService;
import com.multi.service.InstructorService;
import com.multi.service.SchedulesService;


@Controller
public class MainController {	

	@Autowired
	AdminService adminService;
	
	@Autowired
	SchedulesService schedulesservice;
	
	@Autowired
	FacilityService facilityservice;
	
	@Autowired
	InstructorService instructorservice;
	
	@RequestMapping("/index")
	public String index(Model model,String id) {
		AdminDTO admin = null;
	    List<SchedulesDTO> list =null;
		if(id==null) {
			model.addAttribute("center", "index");
		}
		else {
			try {
				admin = adminService.get(id);
				if(admin.getGrade()==2) {
					list=schedulesservice.myschedulelist(id);
					model.addAttribute("center", "maincenter2");
            		model.addAttribute("scheduleslist", list);
				}
				else if(admin.getGrade()==3) {
					String insid=String.valueOf(admin.getInstructorid());
            		list=schedulesservice.insschedulelist(insid);
            		model.addAttribute("scheduleslist", list);
					model.addAttribute("center", "maincenter3");
				}
			} catch (Exception e) {      
				e.printStackTrace();
			}
		}
		return "/index";
	}
	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("center", "register");
		return "index";
	}
	
	
	@RequestMapping("/role")
	public String role(Model model, String role) {
		model.addAttribute("status", "1");
		if(role.equals("1")) {
			model.addAttribute("center", "facilityregister");
		}else {
			model.addAttribute("center", "instructorregister");
		}
		
		return "index";
	}
	
	@RequestMapping("/insregisterimpl")
	public String insregisterimpl(Model model,InstructorDTO ins) {
		FacilityDTO fac=null;
		String imgname = ins.getImg1().getOriginalFilename();   // 파일덩어리 안에있는 파일이름을 꺼낸다. 
		ins.setInstructorimg(imgname);
		imgname=ins.getImg2().getOriginalFilename();
		ins.setInstructorimg2(imgname);
		imgname=ins.getImg3().getOriginalFilename();
		ins.setInstructorimg3(imgname);
		try {
			fac=facilityservice.selectaddr(ins.getAddr());
			ins.setFacilityid(fac.getFacilityid());
			instructorservice.register(ins);
			
			AdminDTO admin = new AdminDTO(ins.getAid(), ins.getPassword(), ins.getInstructorname(), ins.getInstructorphone(), ins.getInstructoremail(), 3, ins.getInstructorid(), 0, null, 0, 0, null, null);
			adminService.register(admin);
			model.addAttribute("status", "1");
			model.addAttribute("center", "login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("center", "register");
			model.addAttribute("registatus", "0");
			e.printStackTrace();
		}
		
		return "index";
	}
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model, FacilityDTO fac) {
		String str;
		String imgname = fac.getImg1().getOriginalFilename();   // 파일덩어리 안에있는 파일이름을 꺼낸다. 
		fac.setFacilityimg(imgname);
		System.out.println(fac);
		if(fac.getWeekdayend().isEmpty()) {
			str="24시 운영";
			fac.setFacilitytime(str);
		}
		else {
			str=fac.getWeekdaystart()+" ~ "+fac.getWeekdayend(); 
			fac.setFacilitytime(str);
		}
		
		if(fac.getWeekendend().isEmpty()) {
			str="24시 운영";
			fac.setFacilitytime2(str);
		}
		else {
			str=fac.getWeekendstart()+" ~ "+fac.getWeekendend(); 
			fac.setFacilitytime2(str);
		}
		
		try {
			facilityservice.register(fac);
			AdminDTO admin = new AdminDTO(fac.getAid(), fac.getPassword(), fac.getName(), fac.getFacilitynumber(), fac.getEmail(), 2, 0, fac.getFacilityid(), null, 0, 0, null, null);
			adminService.register(admin);
			model.addAttribute("center","login");
			model.addAttribute("registatus", "1");
			
		} catch (Exception e) {
			/*
			 * model.addAttribute("center", "register"); model.addAttribute("registatus",
			 * "0");
			 */
			e.printStackTrace();
		}
		
		return "index";
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
	@RequestMapping("/facility_register")
	public String facility_register(Model model) {
		model.addAttribute("center", "facility_register");
		return "index";
	}
	
	@RequestMapping("/todo_list")
	public String todo_list(Model model) {
		model.addAttribute("center", "todo_list");
		return "index";
	}
	
	@RequestMapping("/schedules")
	public String schedules(Model model,String id,String selectday) {
		List<SchedulesDTO> listadmin =null;
		SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd");
		
		if(selectday==null) {
			selectday=sDate.format(new Date());
		}
		try {
			listadmin=schedulesservice.selectdayadmin(selectday, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("adminschedulelist", listadmin);
		model.addAttribute("center", "schedules");
		return "index";
	}
	@RequestMapping("/schedulues/delete")
	public String scheduluesdelete(Model model,int id) {
		try {
			schedulesservice.remove(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("center", "schedules");
		return "index";
	}
	@RequestMapping("/schedulues/fix")
	public String scheduluesfix(Model model,int id) {
		try {
			SchedulesDTO sc=schedulesservice.get(id);
			schedulesservice.modify(sc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("center", "schedules");
		return "index";
	}
	
	@RequestMapping("/insschedules")
	public String insschedules(Model model,String id,String selectday) {
		List<SchedulesDTO> listins =null;
		AdminDTO admin=null;
		SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd");
		
		if(selectday==null) {
			selectday=sDate.format(new Date());
		}
		try {
			admin=adminService.get(id);
			String insid=String.valueOf(admin.getInstructorid());
			listins=schedulesservice.selectdayins(selectday, insid);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("insschedulelist", listins);
		model.addAttribute("center", "insschedules");
		return "index";
	}
	
	@RequestMapping("/insschedulues/delete")
	public String insscheduluesdelete(Model model,int id) {
		try {
			schedulesservice.remove(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("center", "insschedules");
		return "index";
	}
	@RequestMapping("/insschedulues/fix")
	public String insscheduluesfix(Model model,int id) {
		try {
			SchedulesDTO sc=schedulesservice.get(id);
			schedulesservice.modify(sc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("center", "insschedules");
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
		model.addAttribute("status", "1");
		model.addAttribute("center", "login");
		return "index";
	}

	@RequestMapping("/logout")
	public String logout(Model model,HttpSession session) {
			
			if(session != null) {
				session.invalidate();
			}
			return "index";
}
	@RequestMapping("/loginimpl")
	public String loginimpl(String aid, String apwd, Model model, HttpSession session) {   
	      AdminDTO admin = null;
	      List<SchedulesDTO> list =null;
	      
	      try {
	         admin = adminService.get(aid);
	         if(admin == null) {
	        	 model.addAttribute("status", "0");
	        	 model.addAttribute("center", "login");
	         } else {
	            if(apwd.equals(admin.getApwd())) {
	            	session.setAttribute("loginadmin", admin);
	            	model.addAttribute("status", "1");
	            	if(admin.getGrade()==2) {
	            		
	            		list=schedulesservice.myschedulelist(aid);
	            		model.addAttribute("center", "maincenter2");
	            		model.addAttribute("scheduleslist", list);
	            	}
	            	else if(admin.getGrade()==3) {
	            		String insid=String.valueOf(admin.getInstructorid());
	            		list=schedulesservice.insschedulelist(insid);
	            		System.out.println(insid);
	            		model.addAttribute("scheduleslist", list);
	            		model.addAttribute("center", "maincenter3");
	            	}
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








