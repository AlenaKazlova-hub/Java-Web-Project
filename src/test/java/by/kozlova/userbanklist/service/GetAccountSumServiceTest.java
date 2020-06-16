package by.kozlova.userbanklist.service;

import by.kozlova.userbanklist.bean.Account;
import by.kozlova.userbanklist.dao.AccountDao;
import by.kozlova.userbanklist.dao.DaoException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class GetAccountSumServiceTest {

    AccountDao dao = Mockito.mock(AccountDao.class);

    @Test
    public void getAccountSumNoAccounts() throws Exception {
        Mockito.when(dao.getAll()).thenReturn(new ArrayList<>());

        GetAccountSumService service = new GetAccountSumService(dao);

        Assert.assertEquals(0, service.getAccountSum());
    }

    @Test
    public void getAccountSum() throws Exception {
        Account account1 = new Account();
        account1.setAmount(1000);

        Account account2 = new Account();
        account2.setAmount(128);

        List<Account> accountList = new ArrayList<>();
        accountList.add(0,  account1);
        accountList.add(1, account2);

        Mockito.when(dao.getAll()).thenReturn(accountList);

        GetAccountSumService service = new GetAccountSumService(dao);

        Assert.assertEquals(1128, service.getAccountSum());
    }

    @Test
    public void getAccountSumException() throws Exception {
        Mockito.when(dao.getAll()).thenThrow(DaoException.class);

        GetAccountSumService service = new GetAccountSumService(dao);

        Assert.assertThrows(ServiceException.class, () -> service.getAccountSum());
    }
}
