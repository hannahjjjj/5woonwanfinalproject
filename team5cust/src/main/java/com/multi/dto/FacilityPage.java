package com.multi.dto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;


public class FacilityPage {
	
	public void facilityList(List<FacilityDTO> list, String orderby) {
		
		Collections.sort(list, new Comparator<FacilityDTO>() {

			@Override
			public int compare(FacilityDTO o1, FacilityDTO o2) {
				int result = 1;
				switch(orderby) {
				case"facilityname":
					StringBuilder stringBuilder1 = new StringBuilder();
					StringBuilder stringBuilder2 = new StringBuilder();
					for (char c : o1.getFacilityname().toCharArray()) {
						nameFirst(stringBuilder1,c);
					}
					for (char c : o2.getFacilityname().toCharArray()) {
						nameFirst(stringBuilder2,c);
					}
					result = stringBuilder1.toString().compareTo(stringBuilder2.toString());
					break;
				}
				return result;
			}
		});
	}
			public void nameFirst(StringBuilder stringBuilder, char c) {
				if(Pattern.matches("[가-힣]", new StringBuilder(c))) {
					stringBuilder.append((char)(c-44030));
				}else {
					stringBuilder.append((char)(c+44032));
				}
			}
		
	}


			
		
	

	    
	 


