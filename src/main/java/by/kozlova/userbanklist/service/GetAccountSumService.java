package by.kozlova.userbanklist.service;

import by.kozlova.userbanklist.bean.Account;
import by.kozlova.userbanklist.dao.AccountDao;
import by.kozlova.userbanklist.dao.DaoException;

import java.util.List;

public class GetAccountSumService {
	private AccountDao accountDao;

	public GetAccountSumService() {
		this.accountDao = new AccountDao();
	}

	public GetAccountSumService(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public int getAccountSum() throws ServiceException {
		List<Account> accountlist;
		try {
			accountlist = accountDao.getAll();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

		int allAccountSum = 0;

		for (Account account : accountlist) {
			allAccountSum += account.getAmount();

		}

		return allAccountSum;
	}
}
