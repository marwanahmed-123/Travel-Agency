package com.travelagency.Booking;

public class HotelFeesCalculator implements IHotelFeesCalculator {

    @Override
    public double calculateFees(double hotelRoomPrice, int numOfDays) {
        return hotelRoomPrice * numOfDays;
    }
    
}
