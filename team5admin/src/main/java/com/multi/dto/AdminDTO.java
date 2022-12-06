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
public class AdminDTO {
	//관리자 계정 컬럼
	String aid;
	String apwd;
	String aname;
	String acontact;
	String aemail;
	int grade;
	
	//월별 매출에 필요한 변수
	String odate;
	int profit;
	//신규 고객 수
	int cust_count;
	
}
