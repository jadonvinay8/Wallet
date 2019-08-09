package com.cg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.cg.bean.Account;

public class AccountDAOimpl implements AccountDAO {

	Map<String, Account> accMap = new HashMap<String, Account>();
	
	public Connection jdbcSetup() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//establish the connection
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pass = "hr";	
		Connection con = DriverManager.getConnection(url, user, pass);
		System.out.println("Connected successfully to the database");
		
		
		System.out.println();
		return con;
		
	}
	
	@Override
	public boolean addAccount(Account a) throws SQLException {
		// 
		
		Connection con = jdbcSetup();
		
		int id = a.getAid();
		String phone = a.getPhone();
		String name = a.getAccountHolder();
		double bal = a.getBalance();
		
		String query = "INSERT INTO ACCOUNT VALUES(?,?,?,?)";
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, id);
		st.setString(2, phone);
		st.setString(3, name);
		st.setDouble(4, bal);
		
		int insertedRecords = st.executeUpdate();
		System.out.println("Inserted Records: "+ insertedRecords);
		con.commit();
		con.close();
		
		System.out.println("Account successfully added to database.");
		System.out.println();
		
		accMap.put(a.getPhone(), a);
		return true;
	}

	@Override
	public boolean updateAccount(Account a) {
		// update current account
		
		return true;
	}

	@Override
	public boolean deleteAccount(Account a) throws SQLException {
		// 
		accMap.remove(a.getPhone());
		
		Connection con = jdbcSetup();
		int id = a.getAid();
		String query = "DELETE FROM ACCOUNT WHERE id = "+ id;
		PreparedStatement st = con.prepareStatement(query);
		st.executeUpdate();
		
		
		return true;
	}

	@Override
	public Account findAccount(String phone) throws SQLException {
		// 
		Account a = new Account();
		Connection con = jdbcSetup();
		
		Statement st = con.createStatement(); //arguments given. changes are not reflected on giving first argument
		ResultSet rs = st.executeQuery("select * from account where phone =" + phone);
		while(rs.next()) {
			a.setAid(rs.getInt(1));
			a.setPhone(rs.getString(2));
			a.setAccountHolder(rs.getString(3));
			a.setBalance(rs.getDouble(4));
		}
		System.out.println(a);
		return a;
	}

	@Override
	public void getAllAccounts() {
		// 
		try {
			Connection con = jdbcSetup();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from account");
			
			//process the data
			while(rs.next()) {
				
				int a_id = rs.getInt(1);         //pass either position or column name
				String mobile = rs.getString(2);
				String ah = rs.getString(3);
				double bal = rs.getDouble(4);
				
				System.out.println("Account id: " + a_id + " | Phone: " + mobile + " | Name: " + ah + " | Balance: "+bal);
				
				System.out.println();
				System.out.println("=============================================================================");
				System.out.println();
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}



}
