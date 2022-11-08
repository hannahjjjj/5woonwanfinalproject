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
public class CustbodyDTO {
	//고객 신체정보 테이블 기본 컬럼
	int bodyinfoid;
	String custid;
	Date bdate;
	int height;
	int bodyfat;
	int muscle;
	int weight;
}