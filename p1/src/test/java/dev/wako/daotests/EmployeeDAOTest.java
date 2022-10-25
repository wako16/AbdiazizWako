package dev.wako.daotests;

import dev.wako.entities.Employee;
import dev.wako.repositories.EmployeeDAO;
import dev.wako.repositories.EmployeeDAOLocal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class EmployeeDAOTest {
    static EmployeeDAO employeeDAO = new EmployeeDAOLocal();
    @Test
    @Order(1)
    void create_employee_test(){
        Employee newEmployee = new Employee(1,"klawLenord2", "niceguy22",true);
        Employee savedEmployee = employeeDAO.createEmployee(newEmployee);
        Assertions.assertNotEquals(0,savedEmployee.getId());
    }
    @Test
    @Order(2)
    void get_employee_by_id_test(){
        Employee gottenEmployee =employeeDAO.getEmployeeById(1);
        Assertions.assertEquals("klawLenord2",gottenEmployee.getPassword());
    }
    @Test
    @Order(3)
    void update_employee_test(){
        Employee employee = employeeDAO.getEmployeeById(1);
        Employee employee2 = new Employee(employee.getId(),employee.getUsername(),"niceguy22",employee.isAdmin());
        employeeDAO.updateEmployee(employee2);
        Employee updatedEmployee = employeeDAO.getEmployeeById(employee2.getId());
        Assertions.assertEquals("niceguy22",updatedEmployee.getPassword());
    }





    @Test
    @Order(4)

    void delete_employee_by_id_test(){
        boolean result = employeeDAO.deleteEmployeeById(1);
        Assertions.assertTrue(result);
    }



}
