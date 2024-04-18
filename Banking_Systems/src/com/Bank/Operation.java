package com.Bank;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.tech.util.HibernetUtil;

public class Operation {

	Scanner sc = new Scanner(System.in);

	public void Acc_Create() {
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

	public void Acc_Details() {
		SessionFactory sf = HibernetUtil.getSessionFactory();
		Session session = sf.openSession();
		System.out.println("Enter Account Number");
		Account a = session.load(Account.class, sc.nextInt());
		System.out.println("Enter Password");
		if (sc.next().equals(a.getPassword())) {
			System.out.println(a);
		} else
			System.out.println("Password Wrong");
		session.close();
		sf.close();
	}

	public void Balance_Info()

	{
		SessionFactory sf = HibernetUtil.getSessionFactory();
		Session session = sf.openSession();
		System.out.println("Enter Account Number");
		Account a = session.load(Account.class, sc.nextInt());
		System.out.println("Enter Password");
		if (sc.next().equals(a.getPassword())) {
			System.out.println(a.getBalance());
		} else
			System.out.println("Password Wrong");
		session.close();
		sf.close();
		
	}
	
	public void Deposit()
	{
		SessionFactory sf = HibernetUtil.getSessionFactory();
		Session session = sf.openSession();
		System.out.println("Enter Account Number");
		Account a = session.load(Account.class, sc.nextInt());
		System.out.println("Enter Password");
		if (sc.next().equals(a.getPassword())) {
			System.out.println("Enter ammount which you want to deposit");
			a.setBalance(a.getBalance()+sc.nextDouble());
			session.save(a);
			session.beginTransaction().commit();
			System.out.println("Deposit Operation Sucessfully Completed..!");
			
		} else
			System.out.println("Password Wrong");
		session.close();
		sf.close();
	}
public void Withdrall() {
	SessionFactory sf = HibernetUtil.getSessionFactory();
	Session session = sf.openSession();
	System.out.println("Enter Account Number");
	Account a = session.load(Account.class, sc.nextInt());
	System.out.println("Enter Password");
	if (sc.next().equals(a.getPassword())) {
		System.out.println("Enter ammount which you want to withdrawall");
		double d=a.getBalance()-sc.nextDouble();
		if(d>500)
		{
			a.setBalance(d);
			session.save(a);
			session.beginTransaction().commit();
			System.out.println("Withdrwall Operation Sucessfully Completed..!");
			
		}
		else
			System.out.println("Your Account Balance is Low");
		
		
	} else
		System.out.println("Password Wrong");
	session.close();
	sf.close();
}

}
