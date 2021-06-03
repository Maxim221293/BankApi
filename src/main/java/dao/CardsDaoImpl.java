package dao;

import model.Account;
import model.Cards;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardsDaoImpl implements CardsDao {

    private final Connection connection;

    public CardsDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Cards create(String cardsNumber, int accountId) {
        Cards cards = new Cards();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO cards (cards_number, account_id) VALUES (?,?)");
            preparedStatement.setString(1, cardsNumber);
            preparedStatement.setInt(2, accountId);
            preparedStatement.execute();
            try {
                PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM cards WHERE cards_number = ?");
                preparedStatement1.setString(1, cardsNumber);
                ResultSet result = preparedStatement1.executeQuery();
                result.next();

                cards.setCardsId(result.getInt("cards_id"));
                cards.setCardsNumber(result.getString("cards_number"));
                cards.setAccountId(result.getInt("account_id"));
                connection.close();

                return cards;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
                String cardsNumber = result.getString("cards_number");
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
