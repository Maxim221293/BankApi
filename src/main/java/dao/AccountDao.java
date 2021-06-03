package dao;

import model.Account;

public interface AccountDao {

    Account deposit(String accountNumber, long sum);

    Account get(String accountNumber);
}
