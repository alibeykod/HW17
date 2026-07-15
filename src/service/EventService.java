package service;

import exceptions.EventServiceException;
import model.Event;
import repository.EventRepository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class EventService implements GenericService<Event> {
    EventRepository er = new EventRepository();


    @Override
    public void checkForSave(Event ch) {
        if (ch.getTitle() == null || ch.getTitle().isBlank()) {
            throw new EventServiceException("title can not be null !");
        }
        if (ch.getCapacity() <= 0) {
            throw new EventServiceException("capacity can not be negative or zero ");
        }
        if (ch.getPrice() < 0) {
            throw new EventServiceException("ticket price can not be negative ");
        } else {
            er.save(ch);
        }
    }

    @Override
    public void checkForUpdate(Event ch) {
        if (ch.getTitle() == null || ch.getTitle().isBlank()) {
            throw new EventServiceException("title can not be null !");
        }
        if (ch.getCapacity() <= 0) {
            throw new EventServiceException("capacity can not be negative or zero ");
        }
        if (ch.getPrice() < 0) {
            throw new EventServiceException("ticket price can not be negative ");
        } else {
            er.update(ch);
        }
    }

    @Override
    public void checkForDelete(BigInteger id) {
        if (id.compareTo(BigInteger.ZERO) <= 0) {
            throw new EventServiceException("this event not exist to delete !");
        } else {
            er.delete(id);
        }
    }

    @Override
    public Event checkForFindById(BigInteger id) {
        if (id.compareTo(BigInteger.ZERO) <= 0){
            throw new EventServiceException("id can not be zero or negative");
        }
        else {
            return er.findById(id);
        }
    }

    @Override
    public List<Event> checkForFindAll(Event ch) {
        List<Event> events = new ArrayList<>();

        for (Event e: er.findAll()){
            if (e.getId().compareTo(BigInteger.ZERO) <= 0){
                events.add(e);
            }
        }
        return events;
    }
}
