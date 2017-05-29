package com.tickets.order.controller;

import com.tickets.order.dto.Event;
import com.tickets.order.model.Event.EventServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cosmin on 5/28/2017.
 */
@RestController
public class EventController {
    EventServiceImpl event;
    @RequestMapping(value = "/list_events", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getAllEvents(){
        event = new EventServiceImpl();
        List<Event> eventsList = event.getAllEvents();
        if(eventsList==null) {
            return new ResponseEntity<List<Event>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(eventsList.size()==0){
            return new ResponseEntity<List<Event>>(eventsList,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Event>>(eventsList,HttpStatus.OK);
    }
}
