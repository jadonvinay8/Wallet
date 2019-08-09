package com.cg.service;

//import java.util.Map;

import com.cg.Exception.InsufficientFundException;
import com.cg.bean.Account;
import com.cg.dao.AccountDAO;
import com.cg.dao.AccountDAOimpl;

public class AccountService implements Transactions {
	
	AccountDAO dao = new AccountDAOimpl();
	
	@Override
	public double withdraw(Account ob, double amount) throws InsufficientFundException{
		double new_balance = ob.getBalance();
		if(amount > 0) {
			new_balance = ob.getBalance() - amount;
			if(new_balance < 1000.00) {
				new_balance = ob.getBalance();
				System.out.println("Insufficient Balance");
				throw new InsufficientFundException("insufficient fund, cant process withdraw", new_balance);
				
			}
			else {
				ob.setBalance(new_balance);
				
				//update in database
				dao.updateAccount(ob);
				
//				Connection con = dao.jdbcSetup();
//				String phone = ob.getPhone();
//				//String query = "update account set balance = "+ new_balance + " where aid = " + id;
//				Statement st = con.createStatement();
//				st.execute("update account set balance = "+ new_balance + " where phone = " + phone);
//				
//				con.commit();
//				con.close();
			}
		}
		
		
		
		return new_balance;
		
	}

	public double deposit(Account ob, double amount){
		if(amount >= 0) {
			double new_balance = ob.getBalance() + amount;
			ob.setBalance(new_balance);
			
			//update in database
			dao.updateAccount(ob);

			
//			Connection con = dao.jdbcSetup();
//			String phone = ob.getPhone();
//			//String query = "update account set balance = "+ new_balance + " where aid = " + id;
//			Statement st = con.createStatement();
//			st.execute("update account set balance = "+ new_balance + " where phone = " + phone);
//			
//			con.commit();
//			con.close();
			
			return new_balance;
		}
		else {
			System.out.println("can't process deposit as amount is negative");
			return ob.getBalance(); 
		}
		
	}

	@Override
	public double[] transferMoney(Account from, Account to, double amount) {// INCOMPLETE
		double[] arr = new double[2];
		if(amount < 0) {
			System.out.println("Invalid withdrawal..try again with positive amount");
			
			arr[0] = from.getBalance();
			arr[1] = to.getBalance();
			
		}
		else {
			double new_balance = from.getBalance() - amount;
			if(new_balance<1000.00) {
				
				System.out.println("Insufficient Balance");
				arr[0] = from.getBalance();
				arr[1] = to.getBalance();
				
			}
			else {
				from.setBalance(new_balance);
				arr[0] = from.getBalance();
				
				double b2 = to.getBalance()+amount;
				to.setBalance(b2);
				
				arr[1] = to.getBalance();
				
				//update database
				dao.updateAccount(from);
				dao.updateAccount(to);
				
				
//				Connection con = dao.jdbcSetup();
//				String phone1 = from.getPhone();
//				//String query = "update account set balance = "+ new_balance + " where aid = " + id;
//				Statement st1 = con.createStatement();
//				st1.execute("update account set balance = "+ arr[0] + " where phone = " + phone1);
//				
//				//Connection con = dao.jdbcSetup();
//				String phone2 = to.getPhone();
//				//String query = "update account set balance = "+ new_balance + " where aid = " + id;
//				Statement st2 = con.createStatement();
//				st2.execute("update account set balance = "+ arr[1] + " where phone = " + phone2);
//				
//				con.commit();
//				con.close();
			}
		}
		
		return arr;
	}

	@Override
	public boolean addAccount(Account a) {
		
		return dao.addAccount(a);
	}

	@Override
	public boolean deleteAccount(Account a) {
	
		return dao.deleteAccount(a);
	}

	@Override
	public Account findAccount(int id){
		
		return dao.findAccount(id);
	}

	@Override
	public void getAllAccounts() {
		
		dao.getAllAccounts();
	}

}
