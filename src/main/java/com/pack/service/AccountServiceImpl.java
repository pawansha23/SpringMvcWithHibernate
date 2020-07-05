package com.pack.service;

import java.util.ArrayList;

import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.dao.AccountDao;
import com.pack.model.Account;
import com.pack.vo.AccountVO;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Transactional
	public void addAccount(AccountVO accountVO, byte[] targetImg, byte[] targetDoc) {
		Account account = new Account();
		try {
			account.setAccName(accountVO.getAccName());
			account.setAccno(accountVO.getAccno());
			account.setBalance(accountVO.getBalance());
			account.setAge(accountVO.getAge());
			account.setImage(new SerialBlob(targetImg));
			account.setCustomerDoc(new SerialBlob(targetDoc));
			accountDao.addAccount(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// BeanUtils.copyProperties(accountVO, account);

	}

	@Transactional
	public List<AccountVO> showAccounts() {
		List<AccountVO> accountVOs = null;
		List<Account> accounts = accountDao.showAccounts();
		if (accounts != null && !accounts.isEmpty()) {
			accountVOs = new ArrayList<AccountVO>();
			for (Account account : accounts) {
				AccountVO accountVO = new AccountVO();
				try {
					accountVO.setAccName(account.getAccName());
					accountVO.setAccno(account.getAccno());
					accountVO.setBalance(account.getBalance());
					accountVO.setAge(account.getAge());

					byte[] bytes = account.getImage().getBytes(1, (int) account.getImage().length());
					byte[] encodeBase64 = Base64.encodeBase64(bytes);
					String base64Encoded = new String(encodeBase64, "UTF-8");
					accountVO.setDbImage(base64Encoded);

					byte[] docBytes = account.getCustomerDoc().getBytes(1, (int) account.getCustomerDoc().length());
					byte[] docEncodeBase64 = Base64.encodeBase64(docBytes);
					String docBase64Encoded = new String(docEncodeBase64, "UTF-8");
					accountVO.setDbDoc(docBase64Encoded);

					accountVOs.add(accountVO);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

		return accountVOs;
	}

	@Transactional
	public AccountVO getAccount(int accountNo) {
		AccountVO accountVO = new AccountVO();
		Account account = accountDao.getAccount(accountNo);
		accountVO.setAccName(account.getAccName());
		accountVO.setAccno(account.getAccno());
		accountVO.setBalance(account.getBalance());
		accountVO.setAge(account.getAge());

		try {
			byte[] bytes = account.getImage().getBytes(1, (int) account.getImage().length());
			byte[] encodeBase64 = Base64.encodeBase64(bytes);
			String base64Encoded = new String(encodeBase64, "UTF-8");
			accountVO.setDbImage(base64Encoded);

			byte[] docBytes = account.getCustomerDoc().getBytes(1, (int) account.getCustomerDoc().length());
			byte[] docEncodeBase64 = Base64.encodeBase64(docBytes);
			String docBase64Encoded = new String(docEncodeBase64, "UTF-8");
			accountVO.setDbDoc(docBase64Encoded);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accountVO;

	}

}
