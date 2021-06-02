package dao;

import model.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDaoImpl implements AccountDao {

    private final Connection connection;

    public AccountDaoImpl(Connection connection) {
        this.connection = connection;


    }



    @Override
    public String deposit(String accountNumber, int sum) {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM account WHERE account_number ="+accountNumber);

            result.next();
            String accountId = result.getString("account_number");
            String balance = result.getString("balance");
            return (balance+sum);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
return null;
    }

    @Override
    public Account get(String accountNumber) {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM account WHERE account_number ="+accountNumber);
            result.next();
            String accountId = result.getString("account_number");
            String balance = result.getString("balance");
            Account account =new Account();
            account.setAccountId(result.getInt("account_id"));
return account;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }
}
