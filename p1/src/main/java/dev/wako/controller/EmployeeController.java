package dev.wako.controller;

import com.google.gson.Gson;
import dev.wako.driver.Driver;
import dev.wako.entities.Employee;
import io.javalin.http.Handler;

import java.util.List;

public class EmployeeController {
    public Handler createEmployee = (ctx) ->{
        String json = ctx.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(json, Employee.class);
        try{
            Employee registeredEmployee = Driver.employeeService.createEmployee(employee);
            String employeeJson = gson.toJson(registeredEmployee);
            ctx.status(201); //This is a status code that will tell us how things went
            ctx.result(employeeJson);
        }catch (RuntimeException e){
            ctx.status(400);
            ctx.result(e.getMessage());
        }
    };
    public Handler loginHandler = (ctx) ->{
        String json = ctx.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(json, Employee.class);
        try{
            Employee registeredEmployee = Driver.employeeService.loginEmployee(employee);

            if (registeredEmployee != null){
                Driver.loggedInEmployee=registeredEmployee;
                ctx.result("loggin good");
                ctx.status(201);
            }else {
                ctx.result("Employee not found");
                ctx.status(400);
            }

        }catch(RuntimeException e){
            e.printStackTrace();

        }


    };

    public Handler getEmployeeByIdHandler = (ctx) ->{
        int id = Integer.parseInt(ctx.pathParam("id"));//This will take what value was in the {id} and turn it into an int for us to use
        Employee employee = Driver.employeeService.getEmployeeById(id);
        Gson gson = new Gson();
        String json = gson.toJson(employee);
        ctx.result(json);
    };
    public Handler getAllEmployees = (ctx) ->{
        List<Employee> books = Driver.employeeService.getAllEmployees();
        Gson gson = new Gson();
        String json = gson.toJson(books);
        ctx.result(json);
    };

    public Handler updateEmployeeHandler = (ctx) ->{
        String employeeJSON = ctx.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(employeeJSON, Employee.class);
        Employee updateEmployee = Driver.employeeService.updateEmployee(employee);
        String json = gson.toJson(updateEmployee);
        ctx.result(json);
    };


    public Handler deleteEmployeeHandler = (ctx) ->{
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean result = Driver.employeeService.deleteEmployeeById(id);
        if(result){
            ctx.status(204);
        }
        else{
            ctx.status(400);
            ctx.result("Could not process your delete request");
        }
    };
}
