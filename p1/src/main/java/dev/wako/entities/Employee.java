package dev.wako.entities;

public class Employee {
    private int id;
    private String name;
    private String username;
    private String password;
    private String address;
    boolean isAdmin;

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
    public Employee(int id, String name, String username, String password, String address) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }


}
