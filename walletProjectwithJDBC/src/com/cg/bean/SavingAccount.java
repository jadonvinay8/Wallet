package com.cg.bean;

public class SavingAccount extends Account {
	
	private double interest;
	private final double MIN_BALANCE = 1000;
	
	public SavingAccount() {
		// TODO Auto-generated constructor stub
	}

	public SavingAccount(int aid, String phone, String accountHolder, double balance) {
		super(aid, phone, accountHolder, balance);
		// TODO Auto-generated constructor stub
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "SavingAccount [interest=" + interest + "]";
	}
	
	
}
