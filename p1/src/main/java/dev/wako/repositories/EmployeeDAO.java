package dev.wako.repositories;

import dev.wako.entities.Employee;

public interface EmployeeDAO {

    //for non concrete methods

    //create
    Employee createEmployee(Employee employee);
    //Ticket createTicket(Ticket ticket);

    //read
    Employee getEmployeeById(int id);
}
