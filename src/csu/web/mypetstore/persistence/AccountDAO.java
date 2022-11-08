package csu.web.mypetstore.persistence;

import csu.web.mypetstore.domain.Account;

public interface AccountDAO {
    Account getAccountByUsername(String var1);

    Account getAccountByUsernameAndPassword(Account var1);

    void insertAccount(Account var1);

    void insertProfile(Account var1);

    void insertSignon(Account var1);

    void updateAccount(Account var1);

    void updateProfile(Account var1);

    void updateSignon(Account var1);
}
