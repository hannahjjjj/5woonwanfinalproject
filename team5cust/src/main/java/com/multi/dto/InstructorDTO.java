package com.multi.dto;

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
	String instructoremail;
	String instructorphone;
	
}
