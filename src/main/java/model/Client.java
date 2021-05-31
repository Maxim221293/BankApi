package model;

public class Client {
    private int client_id;
    private String first_name;
    private String second_name;
    private String passport_data;
    private String telephone_number;

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getPassport_data() {
        return passport_data;
    }

    public void setPassport_data(String passport_data) {
        this.passport_data = passport_data;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (client_id != client.client_id) return false;
        if (first_name != null ? !first_name.equals(client.first_name) : client.first_name != null) return false;
        if (second_name != null ? !second_name.equals(client.second_name) : client.second_name != null) return false;
        if (passport_data != null ? !passport_data.equals(client.passport_data) : client.passport_data != null)
            return false;
        return telephone_number != null ? telephone_number.equals(client.telephone_number) : client.telephone_number == null;
    }

    @Override
    public int hashCode() {
        int result = client_id;
        result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
        result = 31 * result + (second_name != null ? second_name.hashCode() : 0);
        result = 31 * result + (passport_data != null ? passport_data.hashCode() : 0);
        result = 31 * result + (telephone_number != null ? telephone_number.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_id=" + client_id +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", passport_data='" + passport_data + '\'' +
                ", telephone_number='" + telephone_number + '\'' +
                '}';
    }
}
