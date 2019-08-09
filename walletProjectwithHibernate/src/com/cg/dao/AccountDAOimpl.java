package com.cg.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.bean.Account;

public class AccountDAOimpl implements AccountDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("VINAY");
	EntityManager em = emf.createEntityManager();
	
	Map<String, Account> accMap = new HashMap<String, Account>();
	
	@Override
	public boolean addAccount(Account a) {

		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		
		System.out.println("Account successfully added to database.");
		System.out.println();
		
		accMap.put(a.getPhone(), a);
		return true;
	}

	@Override
	public boolean updateAccount(Account a) {
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteAccount(Account a)  {
		em.getTransaction().begin();
		em.remove(a);
		System.out.println("Record deleted");
		em.getTransaction().commit();
		
		accMap.remove(a.getPhone());
		return true;
	}

	@Override
	public Account findAccount(int id) {
		Account a = em.find(Account.class, id);
		System.out.println(a);
		return a;
	}

	@Override
	public void getAllAccounts() {
		String qry = "select a from Account a";
		Query query = em.createQuery(qry);
		List<Account> accList = query.getResultList();
		for(Account a : accList)
			//System.out.println(a.getAid() + " "  + a.getAccountHolder() + " " + a.getBalance() + " " + a.getPhone() );
			System.out.println(a.toString());

	}



}
