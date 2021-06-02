package dao;

import java.sql.*;

public class DaoFactory {

    private static final String url = "jdbc:h2:/Users/u19215097/BankApi/dataBase/bd";
    private static final String user = "Maxim";
    private static final String password = "";

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    public static CardsDao getCardsDao() {
        try {
            return new CardsDaoImpl(getConnection());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static AccountDao getAccountDao() {
        try {
            return new AccountDaoImpl(getConnection());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}

/*
    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection OK");
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }
*/
