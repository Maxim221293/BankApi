package model;

public class Cards {

    private int cards_id;
    private String account_number;
    private int account_id;

    public Cards() {
    }

    public Cards(int cards_id, String account_number, int account_id) {
        this.cards_id = cards_id;
        this.account_number = account_number;
        this.account_id = account_id;
    }


    public int getCards_id() {
        return cards_id;
    }

    public void setCards_id(int cards_id) {
        this.cards_id = cards_id;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cards cards = (Cards) o;

        if (cards_id != cards.cards_id) return false;
        if (account_id != cards.account_id) return false;
        return account_number != null ? account_number.equals(cards.account_number) : cards.account_number == null;
    }

    @Override
    public int hashCode() {
        int result = cards_id;
        result = 31 * result + (account_number != null ? account_number.hashCode() : 0);
        result = 31 * result + account_id;
        return result;
    }

}
