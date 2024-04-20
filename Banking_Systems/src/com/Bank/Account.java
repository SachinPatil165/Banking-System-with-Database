package com.Bank;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Account {
	@Id
	private int Account_Number;
	private String Name;
	
	private Address Address;
	private long Mobile_Number;
	private String Password;
	private double Balance;
	@Override
	public String toString() {
		return "Account Number  : " + Account_Number +
				"\nName 		: " + Name +"\n"+Address+ 
				"\nMobile Number   : " + Mobile_Number + 
				"\nPassword 	: " + Password + 
				"\nBalance 	: " + Balance;
	}

}
