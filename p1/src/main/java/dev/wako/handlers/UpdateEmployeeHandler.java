package dev.wako.handlers;

import com.google.gson.Gson;
import dev.wako.driver.Driver;
import dev.wako.entities.Employee;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class UpdateEmployeeHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String bookJSON = ctx.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(bookJSON, Employee.class);
        Employee updateEmployee = Driver.employeeService.updateEmployee(employee);
        String json = gson.toJson(updateEmployee);
        ctx.result(json);
    }

}
