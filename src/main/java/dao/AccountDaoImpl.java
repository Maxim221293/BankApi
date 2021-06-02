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

    }

    @Override
    public Account get(String accountNumber) {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM account WHERE account_number ="+accountNumber);
            result.next();
            int accountId = result.getInt("account_number");
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
