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
	private String custid;
	private String custpwd;
	private String custname;
	private String contact;
	private String gender;
	private String birth;
	private String email;
	private String withdrawal;
	private String membership;
	private String addr;
	private String postno;
	private Date expiration;
	private Date custrdate;
	private String kakkoid;
}
