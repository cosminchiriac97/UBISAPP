package com.tickets.order.model.Ticket;

import com.tickets.order.Application;
import com.tickets.order.dto.Ticket;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TicketServiceImpl implements TicketService {
    Connection connection;
    @Override
    public void add(Ticket ticket) {
        connection = Application.getConnection();
        PreparedStatement pstmt = null;
        String sqlStatement = "INSERT INTO TICKET (EVENT_ID,OWNER,PURCHASE_DATE) VALUES(?,?,?)";
        try {
            pstmt = connection.prepareStatement(sqlStatement);
            pstmt.setInt(1,ticket.getEventId());
            pstmt.setString(2,ticket.getOwner());
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            pstmt.setString(3,date);
            pstmt.executeUpdate();
            pstmt.close();
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Ticket getTicketById(int id) {
        connection = Application.getConnection();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        Ticket ticket = null;
        String sqlStatement = "SELECT * FROM TICKET WHERE id = ?";
        try {
            pstmt = connection.prepareStatement(sqlStatement);
            pstmt.setInt(1,id);
            resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                int idTicket = resultSet.getInt("ID");
                int eventId = resultSet.getInt("EVENT_ID");
                String owner = resultSet.getString("OWNER");
                String purchaseDate = resultSet.getString("PURCHASE_DATE");
                ticket = new Ticket(idTicket,eventId,owner,purchaseDate);
            }
            resultSet.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ticket;
    }

    @Override
    public void deleteTicket(int id) {
        connection = Application.getConnection();
        PreparedStatement pstmt = null;
        String sqlStatement = "DELETE FROM TICKET WHERE ID=?";
        try {
            pstmt = connection.prepareStatement(sqlStatement);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            connection.commit();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
