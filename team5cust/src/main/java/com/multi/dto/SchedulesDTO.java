package com.multi.dto;

import java.util.Date;

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
public class SchedulesDTO {
	//스케쥴 테이블 기본 컬럼
	int schedulesid;
	int instructorid;
	String custid;
	Date starttime;
	Date endtime;
	String status;
	
	int period;
	String facilityname;
	String instructorname;
	String itemname;
	int counting;
	String time;
}
