package com.cg.Exception;

public class InsufficientFundException extends Exception {
	
	private double balance;
	
	public InsufficientFundException() {
		// TODO Auto-generated constructor stub
	}
	
	public InsufficientFundException(String msg, double balance) {
		
		super(msg);
		this.balance = balance;
		
	}

	@Override
	public String toString() {
		return "InsufficientFundException [balance=" + balance + "]" + super.getMessage();
	}

	
	
}
