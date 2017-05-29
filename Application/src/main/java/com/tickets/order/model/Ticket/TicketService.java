package com.tickets.order.model.Ticket;

import com.tickets.order.dto.Ticket;
import org.springframework.stereotype.Service;

/**
 * Created by cosmin on 5/27/2017.
 */
@Service
public interface TicketService {
    void add(Ticket ticket);
    Ticket getTicketById(int id);
    void deleteTicket(int id);
}
