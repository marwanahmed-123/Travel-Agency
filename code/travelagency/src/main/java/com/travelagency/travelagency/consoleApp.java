package com.travelagency.travelagency;

import java.util.Scanner;
import java.util.ArrayList;
import com.travelagency.model.*;
import com.travelagency.HotelManagment.*;
import com.travelagency.LocalEventManagment.*;
import com.travelagency.Booking.*;
import java.time.LocalDate;
import com.travelagency.NotificationModule.*;
import com.travelagency.UserManagement.UserManagementCtrl;
import com.travelagency.UserManagement.matchingValidation;

public class consoleApp {
    @SuppressWarnings("null")
    public static void main(String[] args) {
        Model model = new NormalModel();
        Notifications notifications = Notifications.getInstance();
        NotificationManager manager = new EmailNotificationManager(model);
        UserManagementCtrl ctrl = new UserManagementCtrl(new matchingValidation(), model, manager);
        ctrl.Register("111", "111", "111", "111");
        EmailNotificationStatistics stats = EmailNotificationStatistics.getInstance();
        ArrayList<Notification> successful = notifications.getStatusNotifications(true);
        ArrayList<Notification> unsuccessful = notifications.getStatusNotifications(false);
        System.out.println("Size" + notifications.getNotifications().size());
        System.out.println("Successful notifications");
        for (Notification notification : successful) {
            System.out.println(notification.getContent() + " " + notification.getUserid() + " " + notification.getType());
        }
        System.out.println("Unsuccessful notifications");
        for (Notification notification : unsuccessful) {
            System.out.println(notification.getContent() + " " + notification.getUserid() + " " + notification.getType());
        }
        System.out.println("getMostNotified " + stats.getMostNotified());
        System.out.println("getMostSentTemplate " + stats.getMostSentTemplate());
        System.out.println("getNumberOfSuccessfull " + stats.getNumberOfSuccessfull());
        System.out.println("getNumberOfUnSuccessfull " + stats.getNumberOfUnSuccessfull());
        successful = notifications.getStatusNotifications(true);
         unsuccessful = notifications.getStatusNotifications(false);
         System.out.println("successful notifications");
        for (Notification notification : successful) {
            System.out.println(notification.getContent() + " " + notification.getUserid() + " " + notification.getType());
        }
        System.out.println("Unsuccessful notifications");
        for (Notification notification : unsuccessful) {
            System.out.println(notification.getContent() + " " + notification.getUserid() + " " + notification.getType());
        }
        System.out.println("Id is " + successful.get(0).getNotificationId());
        Notification yes = notifications.getByNotificationId(successful.get(0).getNotificationId());
        System.out.println(yes.getContent() + " " + yes.getUserid() + " " + yes.getType());
        String allStatistics = "General notification statistics: ";
        NotificationStatistics statistics = EmailNotificationStatistics.getInstance();
        allStatistics+="\n Most used template for all notification: " + statistics.getMostSentTemplate();
        allStatistics+="\n Number Of successfull: " + statistics.getNumberOfSuccessfull();
        allStatistics+="\n Number Of unsuccessfull: " + statistics.getNumberOfUnSuccessfull();
        allStatistics+="\n Most notified E-mail: " + statistics.getMostNotified();
        statistics = SMSNotificationStatistics.getInstance();
        allStatistics+="\n Most notified number: " + statistics.getMostNotified();
        statistics = DashboardNotificationStatistics.getInstance();
        allStatistics+="\n Most used template for dashboard: " + statistics.getMostNotified();
        System.out.println(allStatistics);
        /*
         * System.out.println("press 1 to search/view hotel rooms");
         * System.out.println("press 2 to search/view local events");
         * System.out.println("press 3 to add Hotel Room booking");
         * System.out.println("press 4 to add Hotel Room booking");
         * System.out.println("press -1 to exit");
         * Scanner input = new Scanner(System.in);
         * while (true) {
         * Integer number = input.nextInt();
         * switch (number) {
         * case 1:
         * SearchHotelRooms search = new SearchHotelRoomsByName();
         * AbstractHotelManagment hotelManagment = new HotelManagment(model, search);
         * input.nextLine();
         * System.out
         * .println(
         * "enter a name of a hotel room or part of it or enter nothing to get all hotel rooms"
         * );
         * String name = input.nextLine();
         * ArrayList<HotelRoom> hotelRooms = hotelManagment.searchHotelRooms(name);
         * for (int i = 0; i < hotelRooms.size(); i++) {
         * HotelRoom room = hotelRooms.get(i);
         * System.out.println("Hotel:" + room.getHotel() + " " + "City:" +
         * room.getCity() + " "
         * + "Address:" + room.getAddress() + " " + "ID:" + room.getHotelRoomID() + " "
         * + "Avalible:" + room.getAvailable() + " " + "Name:" + room.getName() + " " +
         * "Price:"
         * + room.getPrice() + "$");
         * }
         * search = new SearchHotelRoomsByID();
         * hotelManagment.setSearch(search);
         * System.out
         * .println("enter a id of hotel room");
         * String id = input.next();
         * hotelRooms = hotelManagment.searchHotelRooms(id);
         * for (int i = 0; i < hotelRooms.size(); i++) {
         * HotelRoom room = hotelRooms.get(i);
         * System.out.println("Hotel:" + room.getHotel() + " " + "City:" +
         * room.getCity() + " "
         * + "Address:" + room.getAddress() + " " + "ID:" + room.getHotelRoomID() + " "
         * + "Avalible:" + room.getAvailable() + " " + "Name:" + room.getName() + " " +
         * "Price:"
         * + room.getPrice() + "$");
         * }
         * break;
         * case 2:
         * SearchLocalEvents searchEvents = new SearchLocalEventsByName();
         * AbstractLocalEventManagment localEventManagment = new
         * LocalEventManagment(model, searchEvents);
         * input.nextLine();
         * System.out
         * .println(
         * "enter a name of a local event room or part of it or enter nothing to get all local events"
         * );
         * String nameEvent = input.nextLine();
         * ArrayList<LocalEvent> localEvents =
         * localEventManagment.searchLocalEvents(nameEvent);
         * for (int i = 0; i < localEvents.size(); i++) {
         * LocalEvent event = localEvents.get(i);
         * System.out.println("Address:" + event.getAddress() + " " + "City:" +
         * event.getCity() + " "
         * + "ID:" + event.getLocalEventID() + " " + "Organizer:" + event.getOrganizer()
         * + " "
         * + "name:" + event.getName() + " " + "Price:" + event.getPrice() + "$");
         * }
         * System.out
         * .println("enter a id of a local event");
         * String idEvent = input.next();
         * searchEvents = new SearchLocalEventsByID();
         * localEventManagment.setSearch(searchEvents);
         * localEvents = localEventManagment.searchLocalEvents(idEvent);
         * for (int i = 0; i < localEvents.size(); i++) {
         * LocalEvent event = localEvents.get(i);
         * System.out.println("Address:" + event.getAddress() + " " + "City:" +
         * event.getCity() + " "
         * + "ID:" + event.getLocalEventID() + " " + "Organizer:" + event.getOrganizer()
         * + " "
         * + "name:" + event.getName() + " " + "Price:" + event.getPrice() + "$");
         * }
         * default:
         * break;
         * case 3:
         * HotelRoom room = model.getHotelRooms().get(0);
         * // HotelRoomBookingCtrl bookingCtr = new HotelRoomBookingCtrl(model);
         * LocalDate checkInDate = LocalDate.of(2024, 6, 15);
         * LocalDate checkOutDate = LocalDate.of(2024, 6, 20);
         * // bookingCtr.createBooking(room, checkInDate, checkOutDate, "999");
         * ArrayList<AbstractHotelRoomBooking> bookings = model.getHotelRoomBookings();
         * for (int i = 0; i < bookings.size(); i++) {
         * AbstractHotelRoomBooking booking = bookings.get(i);
         * System.out.println(
         * booking.getBookingID() + " " +
         * booking.getCheckInDate() + " " +
         * booking.getCheckOutDate() + " " +
         * booking.getUserID() + " " +
         * booking.getHotelRoomID() + " " +
         * booking.getHotel() + " " +
         * booking.getFees());
         * 
         * }
         * break;
         * case 4:
         * LocalEvent event = model.getLocalEvents().get(0);
         * // LocalEventBookingCtrl eventBookingCtr = new LocalEventBookingCtrl(model);
         * // eventBookingCtr.createBooking("999", event);
         * ArrayList<AbstractLocalEventBooking> events = model.getLocalEventBookings();
         * for (int i = 0; i < events.size(); i++) {
         * AbstractLocalEventBooking eventBooking = events.get(i);
         * System.out.println(
         * eventBooking.getBookingID() + " " +
         * eventBooking.getUserID() + " " +
         * eventBooking.getLocalEventID() + " " +
         * eventBooking.getFees());
         * }
         * }
         * if (number == -1)
         * break;
         * }
         * input.close();
         */
    }
}
