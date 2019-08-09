package com.cg.service;

import java.sql.SQLException;
import java.util.Map;

import com.cg.bean.Account;

public interface AccountOperation {
	
	public boolean addAccount(Account a) throws SQLException;
	public boolean deleteAccount(Account a) throws SQLException;
	public Account findAccount(String phone) throws SQLException;
	public void getAllAccounts();
}
