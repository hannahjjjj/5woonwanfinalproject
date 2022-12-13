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
public class InstructorDTO {
	//강사 테이블 기본 컬럼
	int instructorid;
	int facilityid;
	String instructorname;
	String instructorcon;
	String instructorimg;
	String instructorimg2;
	String instructorimg3;
	String instructoremail;
	String instructorphone;
	
	// 가입을 위한 번호
	private MultipartFile img1;
	private MultipartFile img2;
	private MultipartFile img3;
	String aid;
	String password;
	String addr;
}
