package com.cg.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	
	@Id
	private int aid;
	
	@Column(length=10)
	private String phone;
	
	@Column(length=30)
	private String accountHolder;
	
	@Column
	private double balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int aid, String phone, String accountHolder, double balance) {
		super();
		this.aid = aid;
		this.phone = phone;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [aid=" + aid + ", phone=" + phone + ", accountHolder=" + accountHolder + ", balance=" + balance
				+ "]";
	}
	
}
