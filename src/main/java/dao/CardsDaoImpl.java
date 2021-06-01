package dao;

import model.Cards;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardsDaoImpl implements CardsDao {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Override
    public Cards create(String accountNumber) {

    }


    @Override
    public List<Cards> getAll() {
        List<Cards> cards = new ArrayList<>();

        try {
            ResultSet result = statement.executeQuery("SELECT * FROM cards");

            while (result.next()) {
                int cardsId = result.getInt("cardsId");
                String cardsNumber = result.getString("cardsNumber");
                int accountID = result.getInt("accountId");

                return cards(cardsId, cardsNumber, accountID);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
