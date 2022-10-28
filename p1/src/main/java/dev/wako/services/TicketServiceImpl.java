package dev.wako.services;

import dev.wako.driver.Driver;
import dev.wako.entities.Status;
import dev.wako.entities.Ticket;
import dev.wako.repositories.TicketDAO;

import java.util.List;

public class TicketServiceImpl implements TicketService {

    private TicketDAO ticketDAO;

    public TicketServiceImpl(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }


    @Override
    public Ticket createTicket(Ticket ticket) {
        if (ticket.getDescription().length() == 0) {
            throw new RuntimeException("Description cannot be empty.");
        }

        if (ticket.getAmount() > 3500 ||
                ticket.getAmount() <= 0) {
            throw new RuntimeException("above 3500 dollar limit.");
        }
        try {
            Ticket savedTicket = this.ticketDAO.createTicket(ticket);

            System.out.println(savedTicket.toString());

            return savedTicket;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Ticket getTicketByEmployeeId(int id) {
        return this.ticketDAO.getTicketByEmployeeId(id);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return this.ticketDAO.getAllTickets();
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        if (ticket.getDescription().length() == 0) {
            throw new RuntimeException("Description cannot be empty.");
        }
        if (ticket.getAmount() > 3500) {
            throw new RuntimeException("Amount cannot be in excess of one million dollars.");
        }
        return this.ticketDAO.updateTicket(ticket);
    }

    @Override
    public List<Ticket> getPendingTickets() {
        if(Driver.login.isAdmin()) {
            return this.ticketDAO.getPendingTickets();
        }
        else {
            throw new RuntimeException("only admin can  access to pending tickets!");
        }
    }



    @Override
    public boolean deleteTicketById(int id) {
        return this.ticketDAO.deleteTicket(id);
    }

    @Override
    public String changeTicketStatus(int id, Status status) {
        return this.ticketDAO.changeTicketStatus(id, status);
    }
}
