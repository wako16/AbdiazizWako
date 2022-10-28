package dev.wako.repositories;

import dev.wako.entities.Status;
import dev.wako.entities.Ticket;

import java.util.List;

public interface TicketDAO {


    Ticket createTicket(Ticket ticket);

    Ticket getTicketByEmployeeID(int id);

    Ticket getTicketByEmployeeId(int id);
    List<Ticket> getAllTickets();


    //update
    Ticket updateTicket(Ticket ticket);

    //delete
    boolean deleteTicket(int id);

    String changeTicketStatus(int id, Status status);

    List<Ticket> getPendingTickets();
}
