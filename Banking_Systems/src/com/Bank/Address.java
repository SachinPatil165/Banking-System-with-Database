package com.Bank;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {

	private String CityName;
	private String AreaName;
	private int Pincode;
	@Override
	public String toString() {
		return "CityName 	: " + CityName + 
				"\nAreaName 	: " + AreaName + 
				"\nPincode 	: " + Pincode ;
	}
}
