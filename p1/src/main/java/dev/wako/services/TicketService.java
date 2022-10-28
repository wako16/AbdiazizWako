package dev.wako.services;

import dev.wako.entities.Status;
import dev.wako.entities.Ticket;

import java.util.List;

public interface TicketService {
    //CREATE
    Ticket createTicket(Ticket ticket);
    //READ
    Ticket getTicketByEmployeeId(int id);

    List<Ticket> getAllTickets();
    //UPDATE
    Ticket updateTicket(Ticket ticket);

    List<Ticket> getPendingTickets();

    //DELETE
    boolean deleteTicketById(int id);

    String changeTicketStatus(int id, Status status);
}
