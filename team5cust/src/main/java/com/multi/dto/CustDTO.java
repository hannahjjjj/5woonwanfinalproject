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
public class CustDTO {
	//고객테이블 기본 컬럼
	String custid;
	String custpwd;
	String custname;
	String contact;
	String gender;
	String birth;
	String email;
	String withdrawal;
	String membership;
	String addr;
	String postno;
	Date expiration;
	Date custrdate;
}
