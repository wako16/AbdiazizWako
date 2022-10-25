package dev.wako.repositories;

import dev.wako.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class EmployeeDAOLocal implements EmployeeDAO{
    private Map<Integer, Employee> employeeTable = new HashMap<>();
    private  int idCount = 1;
    @Override
    public Employee createEmployee(Employee employee) {
        employee.setId(idCount);
        idCount++;
        employeeTable.put(employee.getId(), employee);
        System.out.println(employeeTable.values());
        return employee;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeTable.get(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeTable.forEach((key, value) -> {
            employeeList.add(value);
        });
        return employeeList;

    }

    @Override
    public Employee updateEmployee(Employee employee) {

        return employeeTable.put(employee.getId(), employee);
    }

    @Override
    public boolean deleteEmployeeById(int id) {
        Employee employee = employeeTable.remove(id);
        if(employee == null){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public List<Employee> getAllEmployeesOfNames(String username) {
        return null;
    }

}
