package com.cg.service;

import java.util.Map;

import com.cg.bean.Account;

public interface AccountOperation {
	
	public boolean addAccount(Account a);
	public boolean deleteAccount(Account a);
	public Account findAccount(String phone);
	public Map<String, Account> getAllAccounts();
}
