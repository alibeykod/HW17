package service;

import enums.EventStatus;
import exceptions.BusinessException;
import model.Reservation;
import repository.EventRepository;
import repository.ReservationRepository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ReservationService implements GenericService<Reservation> {
        EventRepository er = new EventRepository();
        ReservationRepository rr  = new ReservationRepository();

    @Override
    public void checkForSave(Reservation ch) {
        if (er.findById(ch.getEventId()) == null){
            throw new BusinessException("Event not exist");
        }
        if (er.findById(ch.getEventId()).getStatus().equals(EventStatus.CANCELLED)){
            throw new BusinessException("Event Status Should not be Cancelled !");
        }
        if (er.findById(ch.getEventId()).getCapacity() <= er.findById(ch.getEventId()).getCapacity() - er.findById(ch.getEventId()).getReservedCount()){
            throw new BusinessException("all chairs in event has been sold");
        }
        rr.save(ch);
    }

    @Override
    public void checkForUpdate(Reservation ch) {
        if (er.findById(ch.getEventId()) == null) {
            throw new BusinessException("Event not exist");
        }
        if (er.findById(ch.getEventId()).getStatus().equals(EventStatus.CANCELLED)) {
            throw new BusinessException("Event Status Should not be Cancelled !");
        }
        if (er.findById(ch.getEventId()).getCapacity() <= er.findById(ch.getEventId()).getCapacity() - er.findById(ch.getEventId()).getReservedCount()) {
            throw new BusinessException("all chairs in event has been sold");
        }
        rr.update(ch);
    }

    @Override
    public void checkForDelete(BigInteger id) {
        if (id.compareTo(BigInteger.ZERO) <= 0){
            throw new BusinessException("this id [" + id + "has been not found");
        }
        else rr.delete(id);
    }

    @Override
    public Reservation checkForFindById(BigInteger id) {
        if (id.compareTo(BigInteger.ZERO) <= 0 ){
            throw new BusinessException("id has been not found");
        }
        else {
            return rr.findById(id);
        }
    }

    @Override
    public List<Reservation> checkForFindAll(Reservation ch) {
        List<Reservation> reservationList = new ArrayList<>() ;

        for (Reservation r: reservationList){
            reservationList.add(r);
        }
        return reservationList;
    }
}
