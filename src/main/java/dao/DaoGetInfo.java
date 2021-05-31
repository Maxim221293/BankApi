package dao;

import java.sql.*;

public class DaoGetInfo {
    private static final String url = "jdbc:h2://localhost8080/dataBase";
    private static final String user = "Maxim";
    private static final String password = "";


    private static ResultSet result;
    private static Statement statement;
    private static Connection connection;

        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            //вывод из бд
            result = statement.executeQuery("SELECT * FROM client");
            while (result.next()) {

                int client_id = result.getInt("client_id");
                String first_name = result.getString("first_name");
                String second_name = result.getString("second_name");
                String passport_data = result.getString("passport_data");

                System.out.println(client_id);
                System.out.println(first_name);
                System.out.println(second_name);
                System.out.println(passport_data);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        } finally {
            try {
                connection.close();
                statement.close();
                result.close();
            } catch (SQLException se) {
            }

        }
    }




