package service;

import enums.EventStatus;
import enums.ReservationStatus;
import exceptions.EventException;
import model.Event;
import model.Reservation;
import repository.EventRepository;
import repository.ReservationRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class StreamReports {
    //1
    public long ActiveEvents(EventRepository er){
       return er.findAll().stream()
                .filter(event -> event.getStatus().equals(EventStatus.ACTIVE))
                .count();
    }

    //2
    public Event expensiveEvents(EventRepository er){
        return er.findAll().stream()
                .max((Comparator.comparing(Event::getPrice))).orElseThrow(() -> new EventException("event not found !"));
    }

    //3
    public Double averageOfTicketPrice(EventRepository er){
        return er.findAll().stream()
                .mapToDouble(Event::getPrice)
                .average()
                .orElse(0.0);
    }

    //4
    public List<Reservation> activeReservation(ReservationRepository rr){
        return rr.findAll().stream()
                .filter(reservation -> reservation.getStatus().equals(ReservationStatus.ACTIVE))
                .toList();
    }

    //5
    public List<Event> listOfFullyEvent(EventRepository er){
        return er.findAll().stream()
                .filter(event -> Objects.equals(event.getReservedCount(), event.getCapacity()))
                .toList();
    }

}
