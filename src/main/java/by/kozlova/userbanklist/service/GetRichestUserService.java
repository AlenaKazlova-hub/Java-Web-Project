package by.kozlova.userbanklist.service;

import by.kozlova.userbanklist.bean.Account;
import by.kozlova.userbanklist.bean.User;
import by.kozlova.userbanklist.bean.UserMoney;
import by.kozlova.userbanklist.dao.AccountDao;
import by.kozlova.userbanklist.dao.DaoException;
import by.kozlova.userbanklist.dao.UserDao;

import java.util.*;

public class GetRichestUserService {
	private AccountDao accountDao;
	private UserDao userDao;

	public GetRichestUserService() {
		this.accountDao = new AccountDao();
		this.userDao = new UserDao();
	}

	public GetRichestUserService(AccountDao accountDao, UserDao userDao) {
		this.accountDao = accountDao;
		this.userDao = userDao;
	}

	public User getRichestUser() throws ServiceException {

		List<Account> accountList;
		try {
			accountList = accountDao.getAll();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

		Map<Integer, Integer> userMoneyMap = new HashMap<Integer, Integer>();
		for (Account account : accountList) {
			if (userMoneyMap.containsKey(account.getUserId())) {
				int previousSum = userMoneyMap.get(account.getUserId());
				userMoneyMap.put(account.getUserId(), account.getAmount() + previousSum);
			} else {
				userMoneyMap.put(account.getUserId(), account.getAmount());
			}
		}

		SortedSet<UserMoney> userMoneysorted = new TreeSet<UserMoney>();

		for (Map.Entry<Integer, Integer> entry : userMoneyMap.entrySet()) {
			UserMoney userMoney = new UserMoney(entry.getKey(), entry.getValue());
			userMoneysorted.add(userMoney);
		}

		if (userMoneysorted.isEmpty()) {
			return null;
		}

		UserMoney richestUser = userMoneysorted.last();

		User user;
		try {
			user = userDao.getById(richestUser.getUserId());
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

		return user;

	}
}
