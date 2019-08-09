package com.cg.dao;

import java.util.Map;

import com.cg.bean.Account;

public interface AccountDAO {
	
	public boolean addAccount(Account a);
	public boolean updateAccount(Account a);
	public boolean deleteAccount(Account a);
	public Account findAccount(String phone);
	public Map<String, Account> getAllAccounts();
	

}
