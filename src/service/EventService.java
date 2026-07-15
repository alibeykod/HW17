package service;

import exceptions.EventServiceException;
import model.Event;
import repository.EventRepository;

public class EventService implements GenericService<Event> {
        EventRepository er = new EventRepository();


    @Override
    public int checkForSaveAndUpdate(Event ch) {
        if (ch.getTitle() == null || ch.getTitle().isBlank()){
            throw new EventServiceException("Event can not be null");
        }
        if (ch.getCapacity() < 0 ){
            throw new EventServiceException("Event capacity not be negative");
        }
        if (ch.getPrice() < 0 ){
            throw new EventServiceException("Event Ticket Price can not be negative");
        }
        return 0;
    }

    @Override
    public int checkForDelete(Event ch) {
        if (ch.getTitle() == null || ch.getTitle().isBlank()){
            throw new EventServiceException("Event can not be null");
        }
        if (ch.getCapacity() < 0 ){
            throw new EventServiceException("Event capacity not be negative");
        }
        if (ch.getPrice() < 0 ){
            throw new EventServiceException("Event Ticket Price can not be negative");
        }
        return 0;
    }

    @Override
    public int checkForFindById(Event ch) {
        if (ch.getTitle() == null || ch.getTitle().isBlank()){
            throw new EventServiceException("Event can not be null");
        }
        if (ch.getCapacity() < 0 ){
            throw new EventServiceException("Event capacity not be negative");
        }
        if (ch.getPrice() < 0 ){
            throw new EventServiceException("Event Ticket Price can not be negative");
        }
        return 0;
    }

    @Override
    public int checkForFindAll(Event ch) {
        if (ch.getTitle() == null || ch.getTitle().isBlank()){
            throw new EventServiceException("Event can not be null");
        }
        if (ch.getCapacity() < 0 ){
            throw new EventServiceException("Event capacity not be negative");
        }
        if (ch.getPrice() < 0 ){
            throw new EventServiceException("Event Ticket Price can not be negative");
        }
        return 0;    }
}
