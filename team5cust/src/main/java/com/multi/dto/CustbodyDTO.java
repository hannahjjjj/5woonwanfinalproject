package com.multi.dto;

import java.util.Date;

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
public class CustbodyDTO {
	//고객 신체정보 테이블 기본 컬럼
	int bodyinfoid;
	String custid;
	Date bdate;
	int height;
	double bodyfat;
	double muscle;
	double weight;
	//ocr 파일 읽기위한 변수
	private MultipartFile img;
	private String imgname;
}