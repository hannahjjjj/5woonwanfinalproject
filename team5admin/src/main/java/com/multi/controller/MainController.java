package com.multi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.dto.AdminDTO;
import com.multi.dto.FacilityDTO;
import com.multi.dto.InstructorDTO;
import com.multi.dto.SchedulesDTO;
import com.multi.frame.Util;
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
	
	@Value("${admindir}")
	String admindir;

	@Value("${custdir}")
	String custdir;
	
	@RequestMapping("/index")
	public String index(Model model,String id) {
		AdminDTO admin = null;
	    List<SchedulesDTO> list =null;
	    System.out.println(id);
		if(id.isEmpty()) {
			model.addAttribute("center", "login");
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
			model.addAttribute("center", "searchfacility");
		}
		
		return "index";
	}
	@RequestMapping("/searchfac")
	public String searchfac(Model model, String facilityaddr) {
		List<FacilityDTO> fac= null;
		try {
			fac=facilityservice.searchFacility(facilityaddr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("fac", fac);
		model.addAttribute("status", "1");
		model.addAttribute("center", "instructorregister");
		return "index";
	}
	
	@RequestMapping("/insregisterimpl")
	public String insregisterimpl(Model model,InstructorDTO ins) {
		FacilityDTO fac=null;
		Util.saveFile(ins.getImg1(), admindir, custdir); // 이미지 덩어리를 관리자 디렉, 사용자 디렉에 저장
		Util.saveFile(ins.getImg2(), admindir, custdir); // 이미지 덩어리를 관리자 디렉, 사용자 디렉에 저장
		Util.saveFile(ins.getImg3(), admindir, custdir); // 이미지 덩어리를 관리자 디렉, 사용자 디렉에 저장
		
		String imgname = ins.getImg1().getOriginalFilename();   // 파일덩어리 안에있는 파일이름을 꺼낸다. 
		String[] tempstr1=imgname.split("\\.");
		ins.setInstructorimg(tempstr1[0]);
		
		imgname=ins.getImg2().getOriginalFilename();
		String[] tempstr2=imgname.split("\\.");
		ins.setInstructorimg2(tempstr2[0]);
		imgname=ins.getImg3().getOriginalFilename();
		String[] tempstr3=imgname.split("\\.");
		ins.setInstructorimg3(tempstr3[0]);
		System.out.println(ins);
		try {
			String[] tempstr=ins.getAddr().split(":");
			fac=facilityservice.selectaddr(tempstr[1]);
			
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
		Util.saveFile(fac.getImg1(), admindir, custdir); // 이미지 덩어리를 관리자 디렉, 사용자 디렉에 저장
		String imgname = fac.getImg1().getOriginalFilename();   // 파일덩어리 안에있는 파일이름을 꺼낸다.
		String[] tempstr=imgname.split("\\.");
		fac.setFacilityimg(tempstr[0]);
		System.out.println(fac);
		if(fac.getWeekdayend().isEmpty()) {
			str="24시 운영";
			fac.setFacilitytime(str);
		}
		else {
			str="am "+fac.getWeekdaystart()+" ~ "+" pm "+fac.getWeekdayend(); 
			fac.setFacilitytime(str);
		}
		
		if(fac.getWeekendend().isEmpty()) {
			str="24시 운영";
			fac.setFacilitytime2(str);
		}
		else {
			str="am "+fac.getWeekendstart()+" ~ "+" pm "+fac.getWeekendend(); 
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
	//수정페이지 이동 컨트롤러
	@RequestMapping("/facility_update")
	public String facility_update(Model model,String id) {
		AdminDTO admin=null;
		FacilityDTO fac=null;
		try {
			admin=adminService.get(id);
			fac=facilityservice.get(admin.getFacilityid());
			model.addAttribute("fac", fac);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("center", "facility_update");
		return "index";
	}
	//수정 컨트롤러
	@RequestMapping("/updatefacility")
	public String facility_update(Model model,String id,FacilityDTO fac) {
		String str;
		AdminDTO admin=null;
		Util.saveFile(fac.getImg1(), admindir, custdir);
		String imgname = fac.getImg1().getOriginalFilename();   // 파일덩어리 안에있는 파일이름을 꺼낸다.
		String[] tempstr=imgname.split("\\.");
		fac.setFacilityimg(tempstr[0]);
		
		if(fac.getWeekdayend().isEmpty()) {
			str="24시 운영";
			fac.setFacilitytime(str);
		}
		else {
			str="am "+fac.getWeekdaystart()+" ~ "+" pm "+fac.getWeekdayend(); 
			fac.setFacilitytime(str);
		}
		
		if(fac.getWeekendend().isEmpty()) {
			str="24시 운영";
			fac.setFacilitytime2(str);
		}
		else {
			str="am "+fac.getWeekendstart()+" ~ "+" pm "+fac.getWeekendend(); 
			fac.setFacilitytime2(str);
		}
		try {
			admin=adminService.get(id);
			fac.setFacilityid(admin.getFacilityid());
			facilityservice.modify(fac);
			
			
		} catch (Exception e) {
			/*
			 * model.addAttribute("center", "register"); model.addAttribute("registatus",
			 * "0");
			 */
			
			e.printStackTrace();
		}
		model.addAttribute("fac", fac);
		model.addAttribute("center", "facility_update");
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








