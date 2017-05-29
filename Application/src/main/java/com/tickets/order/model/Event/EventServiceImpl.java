package com.tickets.order.model.Event;

import com.tickets.order.Application;
import com.tickets.order.dto.Event;
import com.tickets.order.dto.Ticket;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EventServiceImpl implements EventService {
    Connection connection;
    @Override
    public List<Event> getAllEvents() {
        List<Event> eventList = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        String sqlStatement = "SELECT * FROM EVENT";
        connection = Application.getConnection();
        try {
            pstmt = connection.prepareStatement(sqlStatement);
            resultSet = pstmt.executeQuery();
            int id;
            String title;
            String description;
            String startDate;
            String endDate;
            while(resultSet.next()){
                id = resultSet.getInt("ID");
                int availableTickets =resultSet.getInt("AVAILABLE_TICKETS");
                title = resultSet.getString("TITLE");
                description = resultSet.getString("DESCRIPTION");
                startDate =resultSet.getString("START_DATE");
                endDate=resultSet.getString("END_DATE");
                eventList.add(new Event(id,availableTickets,title,description,startDate,endDate));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    public Event getEventById(int id){
        connection = Application.getConnection();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        Event event = null;
        String sqlStatement = "SELECT * FROM EVENT WHERE id = ?";
        try {
            pstmt = connection.prepareStatement(sqlStatement);
            pstmt.setInt(1,id);
            resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                int idEvent = resultSet.getInt("ID");
                int availableTickets =resultSet.getInt("AVAILABLE_TICKETS");
                String title = resultSet.getString("TITLE");
                String description = resultSet.getString("DESCRIPTION");
                String startDate = resultSet.getString("START_DATE");
                String endDate = resultSet.getString("END_DATE");
                event = new Event(idEvent,availableTickets,title,description,startDate,endDate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return event;
    }
}
