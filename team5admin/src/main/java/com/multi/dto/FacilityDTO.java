package com.multi.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FacilityDTO { //깃헙 오류
	private int facilityid;
	private int cateid;
	private String facilityname;
	private String facilityaddr;
	private String facilitynumber;
	private String facilityimg;
	private String facilitytime;
	private String facilitytime2;
	private double lat;
	private double lng;
	
	
	private MultipartFile img1;
	
	private String aid;
	private String password;
	private String name;
	private String email;
	private String weekdaystart;
	private String weekdayend;
	private String weekendstart;
	private String weekendend;

}
