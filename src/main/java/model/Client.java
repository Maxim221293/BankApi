package model;

public class Client {
    private int clientId;
    private String firstName;
    private String secondName;
    private String passportData;
    private String telephoneNumber;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassportData() {
        return passportData;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (clientId != client.clientId) return false;
        if (firstName != null ? !firstName.equals(client.firstName) : client.firstName != null) return false;
        if (secondName != null ? !secondName.equals(client.secondName) : client.secondName != null) return false;
        if (passportData != null ? !passportData.equals(client.passportData) : client.passportData != null)
            return false;
        return telephoneNumber != null ? telephoneNumber.equals(client.telephoneNumber) : client.telephoneNumber == null;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (passportData != null ? passportData.hashCode() : 0);
        result = 31 * result + (telephoneNumber != null ? telephoneNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", passportData='" + passportData + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}
