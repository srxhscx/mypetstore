package csu.web.mypetstore.service;

import csu.web.mypetstore.domain.Account;
import csu.web.mypetstore.domain.Consignee;
import csu.web.mypetstore.persistence.AccountDAO;
import csu.web.mypetstore.persistence.ConsigneeDAO;
import csu.web.mypetstore.persistence.impl.AccountDaoImpl;
import csu.web.mypetstore.persistence.impl.ConsigneeDAOImpl;

import java.util.List;

public class AccountService {

    private AccountDAO accountDao = new AccountDaoImpl();

    private ConsigneeDAO consigneeDAO = new ConsigneeDAOImpl();

    public Account getAccount(String username) {
        return this.accountDao.getAccountByUsername(username);
    }

    public Account getAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return this.accountDao.getAccountByUsernameAndPassword(account);
    }

    public void insertAccount(Account account) {
        this.accountDao.insertAccount(account);
        this.accountDao.insertProfile(account);
        this.accountDao.insertSignon(account);
    }

    public void updateAccount(Account account) {
        this.accountDao.updateAccount(account);
        this.accountDao.updateProfile(account);
        if (account.getPassword() != null && account.getPassword().length() > 0) {
            this.accountDao.updateSignon(account);
        }
    }

    public List<Consignee> getConsignee(String username){
        return this.consigneeDAO.getConsigneeByUsername(username);
    }
}
