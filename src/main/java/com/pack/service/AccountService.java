package com.pack.service;

import java.util.List;

import com.pack.vo.AccountVO;

public interface AccountService {
	public void addAccount(AccountVO accountVO, byte[] targetImg, byte[] targetDoc);

	public List<AccountVO> showAccounts();

	public AccountVO getAccount(int accountNo);

}
