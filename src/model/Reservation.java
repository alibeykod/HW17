package model;

import enums.EventStatus;
import enums.ReservationStatus;

import java.util.Date;
import java.math.BigInteger;

public class Reservation {
    private BigInteger id ;
    private String customerName;
    private String customerPhone;
    private BigInteger eventId;
    private Integer ticketCount;
    private Date reservationDate;
    private ReservationStatus status;

    public Reservation(BigInteger id, String customerName, String customerPhone, BigInteger eventId, Integer ticketCount, Date reservationDate, ReservationStatus status) {
        this.id = id;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.eventId = eventId;
        this.ticketCount = ticketCount;
        this.reservationDate = reservationDate;
        this.status = status;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public BigInteger getEventId() {
        return eventId;
    }

    public void setEventId(BigInteger eventId) {
        this.eventId = eventId;
    }

    public Integer getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(Integer ticketCount) {
        this.ticketCount = ticketCount;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", eventId=" + eventId +
                ", ticketCount=" + ticketCount +
                ", reservationDate=" + reservationDate +
                ", status='" + status + '\'' +
                '}';
    }
}
