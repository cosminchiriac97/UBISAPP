package com.tickets.order.dto;

/**
 * Created by cosmin on 5/27/2017.
 */
public class Ticket {
    Integer id;
    int eventId;
    String owner;
    String purchaseDate;

    public Ticket(){

    }

    public Ticket(Integer id, Integer eventId, String owner, String purchaseDate) {
        this.id = id;
        this.eventId = eventId;
        this.owner = owner;
        this.purchaseDate = purchaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
