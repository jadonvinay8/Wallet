package com.cg.service;

import com.cg.bean.Account;

public interface AccountOperation {
	
	public boolean addAccount(Account a);
	public boolean deleteAccount(Account a) ;
	public Account findAccount(int id) ;
	public void getAllAccounts();
}
