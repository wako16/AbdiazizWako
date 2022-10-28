package dev.wako.services;

import dev.wako.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    //read
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();

    //update
    Employee updateEmployee(Employee employee);

    //delete
    boolean deleteEmployeeById(int id);

    Employee loginEmployee(Employee employee);

}
