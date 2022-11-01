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
public class FacilityDTO {
	private int facilityid;
	private int cateid;
	private String facilityname;
	private String facilityaddr;
	private String facilityimg;
	private double lat;
	private double lng;

}
