package model;

import java.math.BigInteger;

public class Event {
    private BigInteger id ;
    private String title;
    private String location;
    private Integer capacity;
    private Integer reservedCount;
    private double price;
    private String status;

    public Event(BigInteger id, String title, String location, Integer capacity, Integer reservedCount, double price, String status) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.capacity = capacity;
        this.reservedCount = reservedCount;
        this.price = price;
        this.status = status;
    }


}
