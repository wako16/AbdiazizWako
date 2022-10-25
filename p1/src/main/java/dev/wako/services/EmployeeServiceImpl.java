package dev.wako.services;

import dev.wako.driver.Driver;
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

        return null;

    }

    @Override
    public Employee loginEmployee(Employee employee) {
        Employee returnedEmployee = null;
        List<Employee> employees = Driver.employeeService.getAllEmployeesOfNames(employee.getUsername());
        for (Employee e : employees){ returnedEmployee = e;

        }
            return returnedEmployee;

    }

    @Override
    public List<Employee> getAllEmployeesOfNames(String username) {
        return this.employeeDAO.getAllEmployeesOfNames(username);

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
