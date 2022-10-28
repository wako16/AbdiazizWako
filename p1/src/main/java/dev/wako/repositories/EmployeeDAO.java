package dev.wako.repositories;

import dev.wako.entities.Employee;
import java.util.List;

public interface EmployeeDAO {

    //for non concrete methods, interface with database

    //create
    Employee createEmployee(Employee employee);
    //Ticket createTicket(Ticket ticket);

    //read
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();

    //update
    Employee updateEmployee(Employee employee);


    //delete
    boolean deleteEmployeeById(int id);

    public Employee getEmployeeByUsername(String username);



}
