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
@Setter
@Getter
@ToString
public class OrdersDTO {
	private int orderid;
	private int itemid;
	private String custid;
	private int instructorid;
	private Date odate;

	
	private String item_name;
	private int item_price;
	private int counting;
	private int period;
	private String instructor_name;
	private String facility_name;
}


