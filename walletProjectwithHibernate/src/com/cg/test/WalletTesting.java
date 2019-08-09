package com.cg.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.cg.Exception.InsufficientFundException;
import com.cg.bean.Account;
import com.cg.service.AccountService;

class WalletTesting {
	
	
	@Test
	void testWithdraw() throws SQLException{
		
		Account a = new Account();
		a.setBalance(50000);
		AccountService service = new AccountService();
		
		try {
			double bal = a.getBalance() - 10000;
			
			assertEquals(service.withdraw(a, 10000) ,bal);
			assertTrue(a.getBalance()>=1000);
		}
		catch(InsufficientFundException e){
			System.out.println("Insufficient fund...can't process withdraw");
		}
		
		
	}
	
	@Test
	void testDeposit() throws SQLException {
		
		Account a = new Account();
		a.setBalance(50000);
		AccountService service = new AccountService();
		
		double bal = a.getBalance() + 25000 ;
		assertEquals(service.deposit(a, -5000),bal);

	}
	
	@Test
	void testTransferMoney() throws SQLException {
		AccountService service = new AccountService();
		
		Account a = new Account();
		a.setBalance(50000);
		Account b = new Account();
		b.setBalance(50000);
		double amount = -5000;
		
		double balExp1 = a.getBalance() - amount;
		double balExp2 = b.getBalance() + amount;

		
		double[] bal = service.transferMoney(a, b, amount);
		double bal1 = bal[0];
		double bal2 = bal[1];
		
		
		assertEquals(balExp1, bal1);
		assertEquals(balExp2, bal2);
		System.out.println("balance of a: "+ bal1);
		System.out.println("balance of b: "+ bal2);


	}
}
