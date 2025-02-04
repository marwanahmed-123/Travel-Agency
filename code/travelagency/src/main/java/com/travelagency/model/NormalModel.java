package com.travelagency.model;

public class NormalModel extends Model {
        public NormalModel() {
                super();
                takeFromDatabaseHotelRooms(null);
                takeFromHotelProvider();
                takeFromDatabaseLocalEvents(null);
                takeFromLocalEventProvider();
                takeFromDatabaseHotelBookings(null);
                takeFromDatabaseLocalEventBookings(null);
                takeFromDatabaseUsers(null);
        }

        @Override
        public void takeFromDatabaseHotelRooms(String query) {
                // Mimicking that it wrote a query to take from the database and returned hotel
                // rooms
                HotelRooms.add(new StandardRoom("Grand Hotel", "New York", "123 Main St", true, "Suite",
                                250.00));
                HotelRooms.add(new StandardRoom("Beachside Resort", "Miami", "456 Ocean Dr", false, "Deluxe",
                                300.00));
                HotelRooms.add(
                                new StandardRoom("Mountain Retreat", "Denver", "789 Alpine Rd", true,
                                                "Standard", 180.00));
                HotelRooms
                                .add(new StandardRoom("City Inn", "Chicago", "1010 Lakeshore Blvd", true,
                                                "Economy", 120.00));
        }

        @Override
        public void takeFromHotelProvider() {
                // Mimicking that it fetched hotel rooms from a hotel provider using API
                HotelRooms.add(new StandardRoom("Paradise Hotel", "Orlando", "221 Magic St", true, "Suite",
                                270.00));
                HotelRooms.add(new StandardRoom("Skyline Inn", "Dallas", "345 Elm Ave", false, "Deluxe",
                                320.00));
                HotelRooms.add(
                                new StandardRoom("Harbor Stay", "San Diego", "567 Shoreline Blvd", true,
                                                "Standard", 190.00));
        }

        @Override
        public void takeFromDatabaseLocalEvents(String query) {
                // Mimicking that it wrote a query to take from the database and returned local
                // events
                LocalEvents
                                .add(new NormalLocalEvent("123 Main St", "New York", "John Doe",
                                                "Tech Conference", 50.00, 5));
                LocalEvents
                                .add(new NormalLocalEvent("456 Oak Ave", "Shelbyville", "Jane Smith",
                                                "Food Festival", 30.00, 10));
                LocalEvents.add(
                                new NormalLocalEvent("789 Pine Rd", "Capital City", "Alice Johnson",
                                                "Music Concert", 75.00, 20));
        }

        public void takeFromLocalEventProvider() {
                // Will return local events from the local event provider using API
                LocalEvents.add(new NormalLocalEvent("111 Elm St", "Greenville", "Bob Brown", "Art Exhibition",
                                40.00, 30));
                LocalEvents.add(new NormalLocalEvent("222 Maple Ave", "Riverside", "Karen White", "Book Fair",
                                25.00, 22));
                LocalEvents.add(new NormalLocalEvent("333 Cedar Rd", "Hill Valley", "Tom Clark", "Charity Run",
                                60.00, 30));
        }

        @Override
        public void takeFromDatabaseUsers(String query) {
                // will return users from the database
                Users.add(new StandardUser("Ahmed", "12345", "@mail", "123456789", true));
        }
}
