package dao;

import model.Account;
import model.Cards;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

  private final Connection connection;

  public AccountDaoImpl(Connection connection) {
    this.connection = connection;

  }

  @Override
  public Account deposit(String accountNumber, int sum) {
    return null;
  }

  @Override
  public Account get(String accountNumber) {
    try {
      Statement statement = connection.createStatement();
      ResultSet result = statement.executeQuery("SELECT * FROM accounts WHERE account_number = " + accountNumber);


        result.next();
        int cardsId = result.getInt("cards_id");
        String cardsNumber = result.getString("account_number");
        int accountId = result.getInt("account_id");

      connection.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    return null;
  }
}
