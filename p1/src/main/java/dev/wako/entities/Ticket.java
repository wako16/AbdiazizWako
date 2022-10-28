package dev.wako.entities;

import java.util.Objects;

public class Ticket {

    private int id;
    private String description;
    private float amount;
    private Status status;

    public Ticket(){
        this.status =Status.PENDING;
    }

    public Ticket(int id, String description, float amount, Status status) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && Double.compare(ticket.amount, amount) == 0 && Objects.equals(description, ticket.description) && status == ticket.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, amount, status);
    }

    public void setid(int id) {
    }
}
