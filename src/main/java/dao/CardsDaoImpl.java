package dao;

import model.Cards;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardsDaoImpl implements CardsDao {

    private final Connection connection;

    public CardsDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Cards create(String accountNumber) {
      return null;
    }


    @Override
    public List<Cards> getAll() {
        List<Cards> cards = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM cards");

            while (result.next()) {
                int cardsId = result.getInt("cards_id");
                String cardsNumber = result.getString("account_number");
                int accountId = result.getInt("account_id");
                cards.add(new Cards(cardsId, cardsNumber, accountId));
            }

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return cards;
    }
}
