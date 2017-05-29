package com.tickets.order.dto;

/**
 * Created by cosmin on 5/27/2017.
 */
public class Event {
    Integer id;
    Integer availableTickets;
    String title;
    String description;
    String startDate;
    String endDate;

    public Event(){

    }

    public Event(int id, int availableTickets, String title, String description, String startDate, String endDate) {
        this.id = id;
        this.availableTickets=availableTickets;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAvailableTickets() {return availableTickets;}

    public void setAvailableTickets(Integer availableTickets) {this.availableTickets = availableTickets;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
