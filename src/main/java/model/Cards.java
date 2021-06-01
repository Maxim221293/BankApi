package model;

public class Cards {

    private int cardsId;
    private String accountNumber;
    private int accountId;

    public Cards() {
    }

    public Cards(int cardsId, String accountNumber, int accountId) {
        this.cardsId = cardsId;
        this.accountNumber = this.getAccountNumber();
        this.accountId = accountId;
    }


    public int getCardsId() {
        return cardsId;
    }

    public void setCardsId(int cardsId) {
        this.cardsId = cardsId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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
        return accountNumber != null ? accountNumber.equals(cards.accountNumber) : cards.accountNumber == null;
    }

    @Override
    public int hashCode() {
        int result = cardsId;
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + accountId;
        return result;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "cardsId=" + cardsId +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountId=" + accountId +
                '}';
    }
}
