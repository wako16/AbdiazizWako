package dev.wako.entities;

import java.util.Objects;

public class Employee {
    private int id;
    private String username;
    private String password;
    private boolean isAdmin;

    public Employee() {
    }
    //Employee
    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
        isAdmin = false;
    }
    //Admin
    public Employee(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    //all-args
    public Employee(int id, String username, String password,boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, password, username);
    }



}
