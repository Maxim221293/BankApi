package model;

public class Cards {

    private int cardsId;
    private String cardsNumber;
    private int accountId;

    public Cards() {
    }

    public Cards(int cardsId, String cardsNumber, int accountId) {
        this.cardsId = cardsId;
        this.cardsNumber = cardsNumber;
        this.accountId = accountId;
    }

    public int getCardsId() {
        return cardsId;
    }

    public void setCardsId(int cardsId) {
        this.cardsId = cardsId;
    }

    public String getCardsNumber() {
        return cardsNumber;
    }

    public void setCardsNumber(String cardsNumber) {
        this.cardsNumber = cardsNumber;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cards cards = (Cards) o;

        if (cardsId != cards.cardsId) return false;
        if (accountId != cards.accountId) return false;
        return cardsNumber != null ? cardsNumber.equals(cards.cardsNumber) : cards.cardsNumber == null;
    }

    @Override
    public int hashCode() {
        int result = cardsId;
        result = 31 * result + (cardsNumber != null ? cardsNumber.hashCode() : 0);
        result = 31 * result + accountId;
        return result;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "cardsId=" + cardsId +
                ", cardsNumber='" + cardsNumber + '\'' +
                ", accountId=" + accountId +
                '}';
    }
}
