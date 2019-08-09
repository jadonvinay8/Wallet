package com.cg.service;

import com.cg.Exception.InsufficientFundException;
import com.cg.bean.Account;

public interface Transactions extends AccountOperation {

		public double withdraw(Account a,double amount) throws InsufficientFundException;
		public double deposit(Account a,double amount);
		public double[] transferMoney(Account from, Account to, double amount);
		
		public default void printStatement(Account a) {
			System.out.println("===============================");
			System.out.println();
			System.out.println("Statement for account number: " + a.getAid());
			System.out.println("Account Holder: " + a.getAccountHolder());
			System.out.println();
			System.out.println("Balance: " + a.getBalance());
			System.out.println("===============================");
		}


}
