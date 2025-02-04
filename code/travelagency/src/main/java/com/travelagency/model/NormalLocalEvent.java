package com.travelagency.model;

public class NormalLocalEvent extends LocalEvent {
    public NormalLocalEvent(String address, String city, String organizer, String name,
            Double price, int numOftickets) {
        super(address, city, organizer, name, price, numOftickets);
    }
}
