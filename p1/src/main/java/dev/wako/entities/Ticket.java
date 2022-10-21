package dev.wako.entities;

public class Ticket {private int id;
    private String user;
    private String amount;
    private String description;
    private String type;

    public Ticket() {
    }

    public Ticket(String user, String amount, String description, String type) {
        this.user = user;
        this.amount = amount;
        this.description = description;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", amount='" + amount + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
