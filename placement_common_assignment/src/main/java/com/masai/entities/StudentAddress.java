package com.masai.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentAddress {
	
	
	private String area;
	private String district;
	private String state;
	private String pincode;
	private String addressType;
	

}
