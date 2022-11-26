package com.multi.dto;

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
public class ItemDTO {
	private int itemid;
	private int facilityid;
	private int instructorid;
	private String itemname;
	private String itemimg;
	private int counting;
	private int period;
	private int itemprice;
	private String itemstate;
	private String instructorname;
	
	private MultipartFile img;
}

