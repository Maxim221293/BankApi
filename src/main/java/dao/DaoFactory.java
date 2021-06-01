package dao;

import java.sql.*;

public class DaoFactory {

    private static final String url = "jdbc:h2://localhost:8080/dataBase";
    private static final String user = "Maxim";
    private static final String password = "";

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(url, user, password);
    }
    public static CardsDao getCardsDao() {
        try {
            return new CardsDaoImpl(getConnection());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public static AccountDao getAccountDao(){

}
}