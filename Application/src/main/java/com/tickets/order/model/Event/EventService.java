package com.tickets.order.model.Event;

import com.tickets.order.dto.Event;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cosmin on 5/27/2017.
 */
@Service
public interface EventService {
    List<Event> getAllEvents();
}
