package dev.wako.handlers;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import dev.wako.driver.Driver;

public class DeleteEmployeeHandler implements Handler{

    @Override
public void handle(@NotNull Context ctx) throws Exception {
    int id = Integer.parseInt(ctx.pathParam("id"));
    boolean result = Driver.employeeService.deleteEmployeeById(id);
    if(result){
        ctx.status(204);
    }
    else{
        ctx.status(400);
        ctx.result("Could not process your delete request");
    }
}
}
