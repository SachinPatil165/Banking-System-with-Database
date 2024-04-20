package com.Bank;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static {
		System.out.println("******** Welcome to SBI Bank ********");
	}
	public static void main(String[] args) {
		int i = 1;
		while (true) {
			System.out.println("1. Create a New Account \n2. Login \n3. Exit");
			switch (sc.nextInt()) {
			case 1:
				Operation.Acc_Create();
				break;
			case 2:
				Operation.Login();
				Operation.Choice();
				break;
			case 3:
				i = 2;
				break;
			default:
				System.out.println("Your choice is Wrong");
			}
			if (i == 2) {
				System.out.println("Thank you for using SBI Bank\nSee you Once again");
				break;
			}
		}
	}
}
