package dao;

import model.Account;

import java.sql.*;

public class AccountDaoImpl implements AccountDao {

    private final Connection connection;

    public AccountDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String deposit(String accountNumber, long sum) {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM account WHERE account_number =" + accountNumber);
            result.next();
            Account account = new Account();
            account.setClientId(result.getInt("account_id"));
            account.setAccountNumber(result.getString("account_number"));
            account.setBalance(result.getLong("balance"));

            long balance = account.getBalance();
            long sumBalance = balance + sum;
            account.setBalance(sumBalance);
            String sqlQuery = "update account set balance = ? where account_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, account.getBalance());
            preparedStatement.setInt(2, account.getAccountId());
            return (String.valueOf(1));

            /*result.next();
            String accountId = result.getString("account_number");
            String balance = result.getString("balance");
            return (balance+sum);*/

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
            ResultSet result = statement.executeQuery("SELECT * FROM account WHERE account_number =" + accountNumber);
            result.next();
            String accountId = result.getString("account_number");
            String balance = result.getString("balance");
            Account account = new Account();
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
