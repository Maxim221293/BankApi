package dao;

import model.Cards;

import java.util.List;

public interface CardsDao {


    Cards create(String cardsNumber, int accountId);

    List <Cards> getAll();
}

