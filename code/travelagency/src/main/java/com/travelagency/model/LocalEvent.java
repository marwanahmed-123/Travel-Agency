package com.travelagency.model;

import java.util.UUID;

public abstract class LocalEvent {
    protected String Address;
    protected String City;
    protected String LocalEventID;
    protected String Organizer;
    protected String name;
    protected Double price;
    protected int numOfTickets;

    public LocalEvent(String address, String city, String organizer, String name, Double price,
            int numOfTickets) {
        String uuid = UUID.randomUUID().toString();
        this.Address = address;
        this.City = city;
        this.LocalEventID = uuid.substring(0, 10);
        this.Organizer = organizer;
        this.name = name;
        this.price = price;
        this.numOfTickets = numOfTickets;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAddress() {
        return Address;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCity() {
        return City;
    }

    public String getLocalEventID() {
        return LocalEventID;
    }

    public void setOrganizer(String organizer) {
        Organizer = organizer;
    }

    public String getOrganizer() {
        return Organizer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public int getNumOfTickets() {
        return numOfTickets;
    }

    public void setNumOfTickets(int numOfTickets) {
        this.numOfTickets = numOfTickets;
    }
}
