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
public class ReviewDTO {
	// 리뷰 테이블 기본 컬럼
	int reivewid;
	int instructorid;
	String reviewcon;
	String starpoint;
	String instructoremail;
	String instructorphone;
	
}
