package dev.wako.driver;

import dev.wako.controller.EmployeeController;
import dev.wako.entities.Employee;
import dev.wako.repositories.EmployeePostgres;
import dev.wako.services.EmployeeService;
import dev.wako.services.EmployeeServiceImpl;
import io.javalin.Javalin;


//postgres.
//prepare statment sql stuff sending to database
//JDBC
public class Driver {
    public static Employee loggedInEmployee = null;


    public static EmployeeService employeeService = new EmployeeServiceImpl(new EmployeePostgres());

    public static void main(String[] args) {
        Javalin app = Javalin.create();
        EmployeeController employeeController = new EmployeeController();
        app.post("/login", employeeController.loginHandler);
        app.start();




















    }
}