package dev.wako.repositories;

import dev.wako.entities.Status;
import dev.wako.entities.Ticket;
import dev.wako.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketPostgres implements TicketDAO{
    @Override
    public Ticket createTicket(Ticket ticket) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            // 'klaw2', 'hotel', '2500', default, null);
            String sql = "insert into ticket value (default,?,?,? )";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //preparedStatement.setInt(1, ticket.getId());
            preparedStatement.setString(1, ticket.getDescription());
            preparedStatement.setDouble(2, ticket.getAmount());
            preparedStatement.setString(3, String.valueOf(ticket.getStatus()));
                        preparedStatement.execute();

            //created ticket record
            ResultSet resultSet = preparedStatement.getGeneratedKeys();


            resultSet.next();

            // get and assign to ticket
            int generatedKey = resultSet.getInt("id");
            ticket.setId(generatedKey);
            return ticket;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

        @Override
        public Ticket getTicketByEmployeeID(int id) {

            try(Connection connection = ConnectionFactory.getConnection()){
                // sql query
                String sql = "SELECT * FROM ticket WHERE id=?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);

                // execute query command on DB
                ResultSet resultSet = preparedStatement.executeQuery();


                resultSet.next();



            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }




    @Override
    public Ticket getTicketByEmployeeId(int id) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select * from ticket where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            // The class PreparedStatement has a method called prepareStatement (no d) that takes in a string
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();

            Ticket ticket = new Ticket();
            ticket.setId(rs.getInt("id"));
            ticket.setDescription(rs.getString("description"));
            ticket.setAmount(rs.getFloat("amount"));
            ticket.setStatus(Status.valueOf(rs.getString("status")));
            return ticket;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Ticket> getAllTickets() {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select * from ticket";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Ticket> ticketList = new ArrayList<>();

            while (rs.next()) {

                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                ticket.setDescription(rs.getString("description"));
                ticket.setAmount(rs.getFloat("amount"));
                ticket.setStatus(Status.valueOf(rs.getString("status")));

                ticketList.add(ticket);
            }

            return ticketList;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public Ticket updateTicket(Ticket ticket) {
        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "update ticketrequest set description=? where id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, ticket.getDescription());
            preparedStatement.setDouble(2,ticket.getAmount());
            preparedStatement.setString(3,ticket.getStatus().name());
            preparedStatement.setInt(4,ticket.getId());

            preparedStatement.executeUpdate();

            return ticket;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteTicket(int id) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "delete from ticket where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public String changeTicketStatus(int id, Status status) {
        return null;
    }

    @Override
    public List<Ticket> getPendingTickets() {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select * from ticket where status = 'PENDING'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Ticket> ticketsList = new ArrayList<>();

            while (rs.next()) {
                Ticket tickets = new Ticket();
                tickets.setId(rs.getInt("id"));
                tickets.setAmount(rs.getFloat("amount"));
                tickets.setDescription(rs.getString("descriptions"));
                tickets.setStatus(Status.valueOf(rs.getString("status")));
                ticketsList.add(tickets);

            }
            return ticketsList;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}

