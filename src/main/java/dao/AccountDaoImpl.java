package dao;

import model.Account;

import java.sql.*;

public class AccountDaoImpl implements AccountDao {

    private final Connection connection;

    public AccountDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Account deposit(String accountNumber, long sum) {

        Account account = new Account();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM account WHERE account_number =" + accountNumber);
            result.next();
            long sumBalance = Long.parseLong(result.getString("balance")) + sum;

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update account set balance = ? where account_number = ?");

            preparedStatement.setLong(1, sumBalance);
            preparedStatement.setString(2, accountNumber);
            preparedStatement.executeUpdate();

            ResultSet result1 = statement.executeQuery("SELECT * FROM account WHERE account_number =" + accountNumber);
            result1.next();
            account.setAccountId(result1.getInt("account_id"));
            account.setAccountNumber(result1.getString("account_number"));
            account.setBalance(result1.getLong("balance"));
            account.setClientId(result1.getInt("client_id"));
            connection.close();
            return account;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Account get(String accountNumber) {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM account WHERE account_number =" + accountNumber);
            result.next();
            Account account = new Account();

            String accountId = result.getString("account_number");
            String balance = result.getString("balance");
            int clientId = result.getInt("client_id");

            account.setAccountId(result.getInt("account_id"));
            account.setAccountNumber(result.getString("account_number"));
            account.setBalance(result.getInt("balance"));
            account.setClientId(result.getInt("client_id"));


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
