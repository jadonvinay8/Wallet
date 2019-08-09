package com.cg.service;

import java.util.Map;

import com.cg.Exception.InsufficientFundException;
import com.cg.bean.Account;
import com.cg.dao.AccountDAO;
import com.cg.dao.AccountDAOimpl;

public class AccountService implements Gst, Transactions {
	
	AccountDAO dao = new AccountDAOimpl();
	
	@Override
	public double withdraw(Account ob, double amount) throws InsufficientFundException {
		// 
		double new_balance = ob.getBalance() - amount;
		if(new_balance < 1000.00) {
					new_balance = ob.getBalance();
					System.out.println("Insufficient Balance");
					//throw new RuntimeException("insufficient fund, cant process withdraw");
					
					throw new InsufficientFundException("insufficient fund, cant process withdraw", new_balance);
					
				}
				ob.setBalance(new_balance);
				return new_balance;
	}

	public double deposit(Account ob, double amount) {
		// 
		double new_balance = ob.getBalance() + amount;
		ob.setBalance(new_balance);
		return new_balance;
	}

	@Override
	public String transferMoney(Account from, Account to, double amount) {// INCOMPLETE
		// 
		double new_balance=from.getBalance()-amount;
		if(new_balance<1000.00) {
			//new_balance=from.getBalance();
			System.out.println("Insufficient Balance");
			//from.setBalance(new_balance);
			return "Amount cannot be transfered insufficient balance";
		}
		from.setBalance(new_balance);
		double b2=to.getBalance()+amount;
		to.setBalance(b2);
		String ans="From Account: "+from.getAid()+" Balance: "+from.getBalance()+"\n"+"To Account: "+to.getAid()+" Balance "+to.getBalance();
		return ans;
	}

	@Override
	public double calculateTax(double percent, double amount) {
		// 
		return amount*Gst.PCT_5;
	}

	@Override
	public boolean addAccount(Account a) {
		// 
		return dao.addAccount(a);
	}

	@Override
	public boolean deleteAccount(Account a) {
		// 
		return dao.deleteAccount(a);
	}

	@Override
	public Account findAccount(String phone) {
		// 
		return dao.findAccount(phone);
	}

	@Override
	public Map<String, Account> getAllAccounts() {
		// 
		return dao.getAllAccounts();
	}

}
