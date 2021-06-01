package dao;

import model.Cards;

import java.util.List;

public interface CardsDao {

    Cards create(String accountNumber);

    List <Cards> getAll();
}

