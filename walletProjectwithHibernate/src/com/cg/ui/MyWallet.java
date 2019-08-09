package com.cg.ui;

import java.io.BufferedReader;
import java.sql.SQLException;
import java.io.*;
import java.util.*;
import com.cg.Exception.InsufficientFundException;
import com.cg.bean.*;
import com.cg.service.*;


public class MyWallet {

		public static void main(String [] args) throws IOException, InsufficientFundException, SQLException {
			

			AccountService service = new AccountService();
			
			Map<String, Account> accMap = new TreeMap<String, Account>();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int choice = 0;
			String read;
			
			while(true) {
				System.out.println("menu");
				System.out.println("================");
				System.out.println("1. Create new account");
				System.out.println("2. Get all accounts");
				System.out.println("3. Delete an account");
				System.out.println("4. Deposit in an account ");
				System.out.println("5. Withdraw from an account ");
				System.out.println("6. Find an account by account id");
				System.out.println("7. Transfer money");

				System.out.println("100.To exit the program ");
				System.out.println();
				System.out.println();

				
				read = br.readLine();
				choice = Integer.parseInt(read);
				
				switch(choice) {
					
				case 1:
					int id = 0 ;
					long number = 0L;
					String s_mb = "";
					String s_name = "";
					double bal = 0.00;
					
					//accepting and validating account number
					System.out.println("Enter account id");
					while(true) {
						String s_id = br.readLine();
						boolean b1 = Validator.validateData(s_id, Validator.aidPattern);
						if(b1) {
							try {
								id = Integer.parseInt(s_id);
								break;
							}
							catch(NumberFormatException e) {
								System.out.println("Account number must be numeric. re-enter");
							}
						
						}
						else
							System.out.println("re enter account number in 3 digits ");
					}
					
					//accepting and validating phone
					System.out.println("Enter mobile number");
					while(true) {
						s_mb = br.readLine();
						boolean b1 = Validator.validateData(s_mb, Validator.phonePattern);
						if(b1) {
							try {
								number = Long.parseLong(s_mb);
								break;
							}
							catch(NumberFormatException e) {
								System.out.println("Phone number must be numeric. re-enter");
							}
						
						}
						else
							System.out.println("Re enter phone number in 10 digits ");
					}
					
					//accepting and validating name
					System.out.println("Enter account holder name: ");
					while(true) {
						s_name = br.readLine();
						boolean b1 = Validator.validateData(s_name, Validator.namePattern);
						if(b1) 
							break;
						else
							System.out.println("Re enter name in alphabets ");
					}
					
					//accepting and validating balance
					System.out.println("Enter balance: ");
					while(true) {
						String s_bal = br.readLine();
						boolean b1 = Validator.validateData(s_bal, Validator.balPattern);
						if(b1) {
							try {
								bal = Double.parseDouble(s_bal);
								break;
							}
							catch(NumberFormatException e) {
								System.out.println("Balance cant be negative. re-enter");
							}
						
						}
						else
							System.out.println("Re enter phone number in 10 digits ");
					}
					Account a = new Account(id, s_mb, s_name, bal);
					service.addAccount(a);
					break;
				
				case 2: //get all accounts
					service.getAllAccounts();
					break;
					
				case 3: //delete an account
					System.out.println("Enter id: ");
					String num = br.readLine();
					
					service.deleteAccount(service.findAccount(Integer.parseInt(num)));
			        System.out.println("Account deleted successfully");
					
					break;
					
				case 4: //deposit
					System.out.println("Enter id: ");
					num = br.readLine().trim();
					
					System.out.println("Enter amount to deposit: ");
					String s = br.readLine().trim();
					int amount = Integer.parseInt(s);
					service.deposit(service.findAccount(Integer.parseInt(num)), amount);
					System.out.println("Amount deposited successfully");
					break;
					
				case 5: //withdraw
					System.out.println("Enter id: ");
					num = br.readLine().trim();
					
					System.out.println("Enter amount to withdraw: ");
					s = br.readLine().trim();
					amount = Integer.parseInt(s);
					try {
						service.withdraw(service.findAccount(Integer.parseInt(num)), amount);
					}
					catch(InsufficientFundException e){
						System.out.println("Insufficient fund..can't process withdraw");
					}
					break;
					
				case 6: //find account by phone
					System.out.println("Enter id: ");
					num = br.readLine();
					service.findAccount(Integer.parseInt(num));
					break;
				
				case 7: //transfer money
					System.out.println("Enter first account's id: ");
					num = br.readLine();
					System.out.println("Enter second account's id: ");
					s = br.readLine();
					System.out.println("Enter amount to be transferred: ");
					double amt = Double.parseDouble(br.readLine());
					service.transferMoney(service.findAccount(Integer.parseInt(num)), service.findAccount(Integer.parseInt(s)), amt);
					break;
					
				case 100:
					System.out.println("Exiting program...");
					System.exit(0);
				
				default:
					System.out.println("Invalid choice....try again....");
				}
			}
			
			
			
			
		}
}
