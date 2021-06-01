package dao;

import java.sql.*;

public class DaoFactory {

    private static final String url = "jdbc:h2:~/bank";
    private static final String user = "sa";
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
            throw new IllegalStateException();
        }
    }

    public static AccountDao getAccountDao(){
        return null;
    }
}