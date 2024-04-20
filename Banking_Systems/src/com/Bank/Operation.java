package com.Bank;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.tech.util.HibernetUtil;

public class Operation {

	static int b = 1;
	static Scanner sc = new Scanner(System.in);
	static private Account account;

	public static void Login() {
		SessionFactory sf = HibernetUtil.getSessionFactory();
		Session session = sf.openSession();
		System.out.println("Enter a Account Number");
		Account a = session.load(Account.class, sc.nextInt());
		System.out.println("Enter Your Password");
		while (true) {
			if (sc.next().equals(a.getPassword())) {
				account = a;
				break;
			} else
				System.out.println("Incorrect Password\nPlease Enter correct Password");
		}
		session.close();
		sf.close();
	}

	public static void Acc_Create() {
		SessionFactory sf = HibernetUtil.getSessionFactory();
		Session session = sf.openSession();
		Account ac = new Account();
		Address ad = new Address();
		System.out.println("Enter Account number");
		ac.setAccount_Number(sc.nextInt());
		System.out.println("Create A Account Password");
		ac.setPassword(sc.next());
		sc.nextLine();
		System.out.println("enter Your Name");
		ac.setName(sc.nextLine());
		System.out.println("enter your City Name");
		ad.setCityName(sc.nextLine());
		System.out.println("Enter Your Area Name");
		ad.setAreaName(sc.nextLine());
		System.out.println("Enter your PinCode");
		ad.setPincode(sc.nextInt());
		ac.setAddress(ad);
		System.out.println("enter your Mobile Number");
		ac.setMobile_Number(sc.nextLong());
		while (true) {
			System.out.println("Enter Deposit Balance");
			double d = sc.nextDouble();
			if (d >= 500) {
				ac.setBalance(d);
				break;
			} else
				System.out.println("Enter ammount is less then $500");
		}
		session.save(ac);
		session.beginTransaction().commit();
		session.close();
		sf.close();
		System.out.println("Account opened Succeful..!");
	}

	public static void Choice() {

		while (true) {
			SessionFactory sf = HibernetUtil.getSessionFactory();
			Session session = sf.openSession();
			Account account2 = session.load(Account.class, account.getAccount_Number());
			System.out.println("1) Account details \n2)"
					+ " Check Balance \n3) Deposit Money \n4) Withdrawal money\n5) Transfer Money\n6) Home");
			int a = sc.nextInt();
			switch (a) {
			case 1:
				System.out.println(account2);
				break;
			case 2:
				System.out.println("Your Account Balance is : " + account2.getBalance());
				break;
			case 3:
				System.out.println("Enter ammount which you want to deposit");
				account2.setBalance(account2.getBalance() + sc.nextDouble());
				System.out.println("Deposit Operation Sucessfully Completed..!");
				session.save(account2);
				session.beginTransaction().commit();
				session.close();
				sf.close();
				break;
			case 4:
				System.out.println("Enter ammount which you want to withdrawall");
				double d = account2.getBalance() - sc.nextDouble();
				if (d > 500) {
					account2.setBalance(d);
					System.out.println("Withdrwall Operation Sucessfully Completed..!");
					session.save(account2);
					session.beginTransaction().commit();
					session.close();
					sf.close();
				} else
					System.out.println("Your Account Balance is Low");

				break;
			case 5:
				System.out.println("Enter Reciver Account Number");
				Account acc = session.load(Account.class, sc.nextInt());
				System.out.println("Enter transfer Ammount");
				double Ammount = sc.nextDouble();
				double amo = account2.getBalance() - Ammount;
				if (amo >= 500) {
					account2.setBalance(amo);
					acc.setBalance(acc.getBalance() + Ammount);
					session.save(acc);
					session.beginTransaction().commit();
					session.close();
					sf.close();
					System.out.println("Ammount Transfer Operatipon Successfully Completed...!");
				} else
					System.out.println("Your Account Balance is Low");
				break;
			case 6:
				b = 2;
				break;
			default:
				System.out.println("wrong choice");
			}
			if (b == 2) {
				break;
			}
			session.close();
			sf.close();
		}

	}

}
