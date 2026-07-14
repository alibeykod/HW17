package service;

import exceptions.EventServiceException;
import model.Event;
import repository.EventRepository;

import java.math.BigDecimal;

public class EventService implements GenericService<Event> {
        EventRepository er = new EventRepository();

    @Override
    public void Check(Event ch) {
        if (ch.getTitle() == null || ch.getTitle().isBlank()){
            throw new EventServiceException("Event can not be null");
        }
        if (ch.getCapacity() < 0 ){
            throw new EventServiceException("Event capacity not be negative");
        }
        if (ch.getPrice() < 0 ){
            throw new EventServiceException("Event Ticket Price can not be negative");
        }
    }

}
