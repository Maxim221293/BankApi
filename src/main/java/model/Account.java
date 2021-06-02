package model;


public class Account {
    private int accountId;
    private String accountNumber;
    private long balance;
    private int clientId;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (accountId != account.accountId) return false;
        if (balance != account.balance) return false;
        if (clientId != account.clientId) return false;
        return accountNumber != null ? accountNumber.equals(account.accountNumber) : account.accountNumber == null;
    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (int) (balance ^ (balance >>> 32));
        result = 31 * result + clientId;
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", clientId=" + clientId +
                '}';
    }
}