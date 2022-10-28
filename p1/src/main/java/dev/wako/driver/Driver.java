package dev.wako.driver;

import dev.wako.controller.EmployeeController;
import dev.wako.controller.TicketController;
import dev.wako.entities.Employee;
import dev.wako.repositories.EmployeePostgres;
import dev.wako.repositories.TicketDAO;
import dev.wako.services.EmployeeService;
import dev.wako.services.EmployeeServiceImpl;
import io.javalin.Javalin;


//postgres.
//prepare statment sql stuff sending to database
//JDBC
public class Driver {
    public static Employee loggedInEmployee = null;


    public static EmployeeService employeeService = new EmployeeServiceImpl(new EmployeePostgres());
    public static TicketDAO ticketService;
    public static Employee login = null;

    public static void main(String[] args) {
        Javalin app = Javalin.create();
        EmployeeController employeeController = new EmployeeController();
        TicketController ticketController = new TicketController();
        app.post("/login", employeeController.loginHandler);

        //crud methods

        //put in driverapp.get("/hello", helloHandler);

                app.get("/employee/{id}", employeeController.getEmployeeByIdHandler);

                app.get("/employee", employeeController.getAllEmployees);



                //create user
                app.post("/employee", employeeController.createEmployee);


                //create ticket
                app.post("/ticket", ticketController.createTicketHandler);
        //pending
        app.get("/pending", ticketController.getPendingTicketsHandler);
        //alltickets
        app.get("/alltickets", ticketController.getAllTicketsHandler);


        //app.put("/updateStatus", ticketController.updateStatusHandler);


        app.start();




















    }
}