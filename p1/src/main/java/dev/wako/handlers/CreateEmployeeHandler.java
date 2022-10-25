package dev.wako.handlers;

import com.google.gson.Gson;
import dev.wako.driver.Driver;
import dev.wako.entities.Employee;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;




public class CreateEmployeeHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String json = ctx.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(json, Employee.class);
        Employee registeredEmployee = Driver.employeeService.createEmployee(employee);
        String employeeJson = gson.toJson(registeredEmployee);
        ctx.status(201); //This is a status code that will tell us how things went
        ctx.result(employeeJson);

    }
}
