package dev.wako.services;

import dev.wako.entities.Employee;
import dev.wako.repositories.EmployeeDAO;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }


    @Override
    public Employee createEmployee(Employee employee) {

        if(employee.getUsername().length() == 0){
            throw new RuntimeException("Username cannot be empty");
        }
        if(employee.getPassword() == null){
            throw new RuntimeException("Password cannot be empty");
        }else {
            Employee savedEmployee = this.employeeDAO.createEmployee(employee);

            return savedEmployee;
        }


    }

    @Override
    public Employee loginEmployee(Employee employee) {
        Employee returnedEmployee =  this.employeeDAO.getEmployeeByUsername(employee.getUsername());
        return returnedEmployee;
    }




    @Override
    public Employee getEmployeeById(int id) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public boolean deleteEmployeeById(int id) {
        return false;
    }
}
