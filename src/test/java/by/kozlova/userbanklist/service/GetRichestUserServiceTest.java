package by.kozlova.userbanklist.service;

import by.kozlova.userbanklist.bean.Account;
import by.kozlova.userbanklist.bean.User;
import by.kozlova.userbanklist.dao.AccountDao;
import by.kozlova.userbanklist.dao.DaoException;
import by.kozlova.userbanklist.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class GetRichestUserServiceTest {
    AccountDao accountDao = Mockito.mock(AccountDao.class);
    UserDao usertDao = Mockito.mock(UserDao.class);

    @Test
    public void getRichestUserNoAccounts() throws Exception {
        Mockito.when(accountDao.getAll()).thenReturn(new ArrayList<>());
        Mockito.when(usertDao.getById(1)).thenReturn(new User());

        GetRichestUserService service = new GetRichestUserService(accountDao, usertDao);

        Assert.assertNull(service.getRichestUser());
    }

    @Test
    public void getRichestUserException() throws Exception {
        Mockito.when(accountDao.getAll()).thenThrow(DaoException.class);
        Mockito.when(usertDao.getById(1)).thenReturn(new User());

        GetRichestUserService service = new GetRichestUserService(accountDao, usertDao);

        Assert.assertThrows(ServiceException.class, () -> service.getRichestUser());
    }

    @Test
    public void getRichestUser() throws Exception {
        User user1 = new User();
        user1.setName("Lena");
        user1.setSurname("Kozlova");
        user1.setId(1);

        Account account1 = new Account();
        account1.setAmount(1000);
        account1.setUserId(1);

        User user2 = new User();
        user2.setName("Sveta");
        user2.setSurname("Sokolova");
        user2.setId(2);

        Account account2 = new Account();
        account2.setAmount(128);
        account2.setUserId(2);

        Account account3 = new Account();
        account3.setAmount(1000);
        account3.setUserId(2);

        List<Account> accountList = new ArrayList<>();
        accountList.add(0,  account1);
        accountList.add(1, account2);
        accountList.add(2, account3);

        Mockito.when(accountDao.getAll()).thenReturn(accountList);
        Mockito.when(usertDao.getById(1)).thenReturn(user1);
        Mockito.when(usertDao.getById(2)).thenReturn(user2);

        GetRichestUserService service = new GetRichestUserService(accountDao, usertDao);

        Assert.assertEquals(user2, service.getRichestUser());
    }

}
