package dev.wako.controller;

import com.google.gson.Gson;
import dev.wako.driver.Driver;
import dev.wako.entities.Ticket;
import io.javalin.http.Handler;

import java.util.List;



public class TicketController {
    public Handler makeNewTicketHandler = (ctx) ->{
    String json = ctx.body();
    Gson gson = new Gson();
    Ticket newRequest = gson.fromJson(json, Ticket.class);

    Ticket ticket = new Ticket();
    ticket.setid(Driver.loggedInEmployee.getId());
    ticket.setAmount((float) newRequest.getAmount());
    ticket.setDescription(newRequest.getDescription());

    try {
        Ticket registeredTicket = Driver.ticketService.createTicket(ticket);
        String ticketJson = gson.toJson(registeredTicket);
        ctx.status(201);
        ctx.result(ticketJson);
    } catch (RuntimeException e) {
        e.printStackTrace();
        ctx.status(400);
        ctx.result(e.getMessage());
    }

};

    public Handler getAllTicketsHandler = (ctx) ->{
        List<Ticket> ticketList = Driver.ticketService.getAllTickets();
        Gson gson = new Gson();
        String json = gson.toJson(ticketList);
        ctx.result(json);
    };



    // Get all tickets that a specific employee has submitted
    public Handler getTicketForEmployeeHandler = (ctx) ->{
        int id = Integer.parseInt(ctx.pathParam("id"));
        List<Ticket> ticketList = (List<Ticket>) Driver.ticketService.getTicketByEmployeeId(id);
        Gson gson = new Gson();
        String json = gson.toJson(ticketList);
        ctx.result(json);
    };

    public Handler showUsersOwnTicketHandler = (ctx) ->{
        System.out.println("users request---");
        int id = Driver.loggedInEmployee.getId();
        List<Ticket> ticketList = (List<Ticket>) Driver.ticketService.getTicketByEmployeeId(id);
        System.out.println("ticketList");
        Gson gson = new Gson();
        String json = gson.toJson(ticketList);
        ctx.result(json);
    };

    public Handler getPendingTicketsHandler = (ctx) ->{
        try {
            List<Ticket> tickets = Driver.ticketService.getPendingTickets();
            Gson gson = new Gson();
            String json = gson.toJson(tickets);
            ctx.result(json);
        }
        catch (RuntimeException e){
            ctx.status(404);
            ctx.result("error");
        }
    };




    public Handler createTicketHandler = (ctx) ->{
        String json = ctx.body();
        Gson gson = new Gson();
        Ticket ticketRequest = gson.fromJson(json, Ticket.class);
//        Ticket testTicket = Driver.ticketService.createTicket(ticketRequest);
//        System.out.println(testTicket);
        try{
            Ticket registeredTicket = Driver.ticketService.createTicket(ticketRequest);
            String reimbursementRequestJson = gson.toJson(registeredTicket);
            ctx.status(201);
            ctx.result(reimbursementRequestJson);
        }
        catch (RuntimeException e){
            ctx.status(400);
            ctx.result(json);
            //e.getMessage()
        }
    };

    public Handler getTicketByIdHandler = (ctx) ->{
        int id = Integer.parseInt(ctx.pathParam("id"));//This will take what value was in the {id} and turn it into an int for us to use
        Ticket ticket = Driver.ticketService.getTicketByEmployeeId(id);
        Gson gson = new Gson();
        String json = gson.toJson(ticket);
        ctx.result(json);
    };

    public Handler updateTicketHandler = (ctx) ->{
        String reimbursementRequestJSON = ctx.body();
        Gson gson = new Gson();
        Ticket ticket = gson.fromJson(reimbursementRequestJSON, Ticket.class);
        Ticket updatedReimbursementRequest = Driver.ticketService.updateTicket(ticket);
        String json = gson.toJson(updatedReimbursementRequest);
        ctx.result(json);
    };

    public Handler getAllTickets = (ctx) ->{
        List<Ticket> tickets = Driver.ticketService.getAllTickets();
        Gson gson = new Gson();
        String json = gson.toJson(tickets);
        ctx.result(json);
    };



    public Handler deleteTicketHandler = (ctx) ->{
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean result = Driver.ticketService.deleteTicket(id);
        if(result){
            ctx.status(204);
        }
        else{
            ctx.status(400);
            ctx.result("Could not process your delete request");
        }
    };


}
