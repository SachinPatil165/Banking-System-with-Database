package com.Bank;

import java.util.Scanner;

public class Main {

	int b=1;
	public void Choice()
	{
		Scanner sc=new Scanner(System.in);
		Operation op =new Operation();
		
		System.out.println(
				" Welcome SBI Bank \n select option from bellow \n 1) Account Create \n 2) Show Account details \n 3)"
						+ " Balance enquiri \n 4) Deposit Money \n 5) Withdrawal money\n 6) Exit");
		int a = sc.nextInt();
		switch (a) {
		case 1:
			op.Acc_Create();
			break;
		case 2:
			op.Acc_Details();
			break;
		case 3:
			op.Balance_Info();
			break;
		case 4:
			op.Deposit();
			break;
		case 5:
			op.Withdrall();
			break;
		case 6:
			b=2;
			break;
		
		default:
			System.out.println("wrong choice");

		}
		

	}
	public static void main(String[] args) {
		Main m = new Main();
		
				while (true) {
		
					if (m.b == 2) {
						System.out.println("Thank You..!");
						System.out.println("See You Once again");
						break;
					} else {
						m.Choice();
					}
		
				}
	}
}
