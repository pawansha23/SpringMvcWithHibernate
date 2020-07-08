package com.pack.dao;

import java.util.List;

import com.pack.model.Account;
import com.pack.vo.AccountVO;

public interface AccountDao {

	public void addAccount(Account account);

	public List<Account> showAccounts();

	public Account getAccount(int accountNo);
}
