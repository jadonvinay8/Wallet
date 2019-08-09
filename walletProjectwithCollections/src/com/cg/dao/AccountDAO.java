package com.cg.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import com.cg.bean.Account;

public interface AccountDAO {
	
	public Connection jdbcSetup() throws SQLException ;
	public boolean addAccount(Account a) throws SQLException;
	public boolean updateAccount(Account a);
	public boolean deleteAccount(Account a) throws SQLException;
	public Account findAccount(String phone) throws SQLException;
	public void getAllAccounts();
	

}
