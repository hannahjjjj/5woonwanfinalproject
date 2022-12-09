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
public class ReviewDTO {
	// 리뷰 테이블 기본 컬럼
	int reviewid;
	int facilityid;
	String custid;
	String reviewcon;
	int starpoint;
	Date rdate;
	
	public ReviewDTO(int facilityid,String custid, String reviewcon,int starpoint) {
		super();
		this.custid=custid;
		this.facilityid=facilityid;
		this.reviewcon=reviewcon;
		this.starpoint=starpoint;
	}
	
	
}
