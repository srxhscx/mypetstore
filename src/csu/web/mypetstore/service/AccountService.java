package csu.web.mypetstore.service;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.persistence.AccountDAO;
import csu.web.mypetstore.persistence.impl.AccountDaoImpl;

public class AccountService {

    private AccountDAO accountDao;

    public AccountService(){
        accountDao = new AccountDaoImpl();
    }

    public Account getAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return this.accountDao.getAccountByUsernameAndPassword(account);
    }
}