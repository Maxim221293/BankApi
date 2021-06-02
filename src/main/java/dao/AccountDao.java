package dao;

import model.Account;

public interface AccountDao {

    String deposit(String accountNumber, int sum);

    Account get(String accountNumber);
}
