package model;

import enums.EventStatus;

import java.math.BigInteger;
import java.util.List;

public class Event {
    private BigInteger id ;
    private String title;
    private String location;
    private Integer capacity;
    private Integer reservedCount;
    private double price;
    private EventStatus status;
    private List<Event> eventList;

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public Event(BigInteger id, String title, String location, Integer capacity, Integer reservedCount, double price, EventStatus status) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.capacity = capacity;
        this.reservedCount = reservedCount;
        this.price = price;
        this.status = status;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getReservedCount() {
        return reservedCount;
    }

    public void setReservedCount(Integer reservedCount) {
        this.reservedCount = reservedCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", reservedCount=" + reservedCount +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
