package dao;

import model.Account;

public interface AccountDao {

    Account deposit(String accountNumber, int sum);

    Account get(String accountNumber);
}
