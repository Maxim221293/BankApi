package model;

public class Account {
    private int account_id;
    private String account_number;
    private String balance;
    private int client_id;

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (account_id != account.account_id) return false;
        if (client_id != account.client_id) return false;
        if (account_number != null ? !account_number.equals(account.account_number) : account.account_number != null)
            return false;
        return balance != null ? balance.equals(account.balance) : account.balance == null;
    }

    @Override
    public int hashCode() {
        int result = account_id;
        result = 31 * result + (account_number != null ? account_number.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + client_id;
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", account_number='" + account_number + '\'' +
                ", balance='" + balance + '\'' +
                ", client_id=" + client_id +
                '}';
    }
}
