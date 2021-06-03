package dao;

import model.Account;

public interface AccountDao {

    String deposit(String accountNumber, long sum);

    Account get(String accountNumber);
}
