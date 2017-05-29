package com.tickets.order.controller;

import com.tickets.order.dto.Ticket;
import com.tickets.order.model.Event.EventServiceImpl;
import com.tickets.order.model.Ticket.TicketServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cosmin on 5/28/2017.
 */
@RestController
public class TicketController {

    private TicketServiceImpl service =new TicketServiceImpl();
    private EventServiceImpl serviceEvent = new EventServiceImpl();

    @RequestMapping(value="/ticket_details/{id}", method= RequestMethod.GET)
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") int id){
        Ticket ticket = service.getTicketById(id);
        if(ticket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(ticket,HttpStatus.OK);
        }
    }

    @RequestMapping(value="/buy_ticket", method=RequestMethod.POST)
    public ResponseEntity<String> addTicket(@RequestBody Ticket ticket){

        if(ticket.getOwner()==null){
            return new ResponseEntity<String>("Missing parameters",HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if(serviceEvent.getEventById(ticket.getEventId())==null){
            return new ResponseEntity<String>("This event does not exist",HttpStatus.NOT_FOUND);
        }
        if(serviceEvent.getEventById(ticket.getEventId()).getAvailableTickets()<1){
            return new ResponseEntity<String>("There are no tickets for sale",HttpStatus.NO_CONTENT);
        }
        this.service.add(ticket);
        return new ResponseEntity<String>("You have successfully added your ticket",HttpStatus.OK);
    }

    @RequestMapping(value="/cancel_ticket", method=RequestMethod.POST)
    public ResponseEntity<String> cancelTicket(@RequestBody Ticket ticket){
        if(ticket.getOwner()==null){
            return new ResponseEntity<String>("Missing parameters",HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if(service.getTicketById(ticket.getId())==null){
            return new ResponseEntity<String>("This event does not exist",HttpStatus.NOT_FOUND);
        }
        service.deleteTicket(ticket.getId());
        return new ResponseEntity<String>("You have successfully canceled your ticket",HttpStatus.NO_CONTENT);

    }
}
