package com.cg.dao;

import java.util.*;

import com.cg.bean.Account;

public class AccountDAOimpl implements AccountDAO {

	Map<String, Account> accMap = new HashMap<String, Account>();
	
	@Override
	public boolean addAccount(Account a) {
		// 
		accMap.put(a.getPhone(), a);
		return true;
	}

	@Override
	public boolean updateAccount(Account a) {
		// update current account
		
		return true;
	}

	@Override
	public boolean deleteAccount(Account a) {
		// 
		accMap.remove(a.getPhone());
		return true;
	}

	@Override
	public Account findAccount(String phone) {
		// 
		System.out.println(accMap);
		return accMap.get(phone);
	}

	@Override
	public Map<String, Account> getAllAccounts() {
		// 
		return accMap;
	}



}
