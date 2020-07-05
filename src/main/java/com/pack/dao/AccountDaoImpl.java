package com.pack.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pack.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addAccount(Account account) {
		System.out.println(account);
		sessionFactory.getCurrentSession().save(account);

	}
	
	public Account getAccount(int accountNo) {
		return (Account) sessionFactory.getCurrentSession().get(Account.class, accountNo);

	}

	public List<Account> showAccounts() {
		return sessionFactory.getCurrentSession().createCriteria(Account.class).list();

	}

}
