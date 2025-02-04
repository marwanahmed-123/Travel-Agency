package com.travelagency.SpringController;

import java.time.LocalDate;
import java.util.ArrayList;
import com.travelagency.model.*;
import com.travelagency.Dashboard.*;
import com.travelagency.Booking.HotelRoomBookingCtrl;
import com.travelagency.Booking.LocalEventBookingCtrl;
import com.travelagency.HotelManagment.*;
import com.travelagency.LocalEventManagment.*;
import com.travelagency.NotificationModule.*;
import com.travelagency.UserManagement.UserManagementCtrl;
import com.travelagency.UserManagement.matchingValidation;
import com.travelagency.IDsearcher.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("travelagency")
public class SpringController {
    Model model = new NormalModel();
    IDsearcher searchID = new IDsearcher(model);
    Notifications notifications = Notifications.getInstance();
    NotificationManager manager = new EmailNotificationManager(model);

    @GetMapping("searchHotelRoomWithName/{name}")
    public ArrayList<HotelRoom> searchHotelRooms(@PathVariable("name") String name) {
        AbstractHotelManagment hotelManagment = new HotelManagment(model, new SearchHotelRoomsByName(),
                new AddStandardRoom());
        return hotelManagment.searchHotelRooms(name);
    }

    @GetMapping("searchHotelRoomWithName")
    public ArrayList<HotelRoom> viewHotelRooms() {
        AbstractHotelManagment hotelManagment = new HotelManagment(model, new SearchHotelRoomsByName(),
                new AddStandardRoom());
        return hotelManagment.searchHotelRooms("");
    }

    @GetMapping("searchHotelRoomWithID/{id}")
    public ArrayList<HotelRoom> searchHotelRoomsWithID(@PathVariable("id") String id) {
        AbstractHotelManagment hotelManagment = new HotelManagment(model, new SearchHotelRoomsByID(),
                new AddStandardRoom());
        return hotelManagment.searchHotelRooms(id);
    }

    @GetMapping("searchLocalEventWithName/{name}")
    public ArrayList<LocalEvent> searchLocalEvent(@PathVariable("name") String name) {
        AbstractLocalEventManagment localEventManagment = new LocalEventManagment(model, new SearchLocalEventsByName(),
                new AddNormalLocalEvent());
        return localEventManagment.searchLocalEvents(name);
    }

    @GetMapping("searchLocalEventWithName")
    public ArrayList<LocalEvent> viewLocalEvent() {
        AbstractLocalEventManagment localEventManagment = new LocalEventManagment(model, new SearchLocalEventsByName(),
                new AddNormalLocalEvent());
        return localEventManagment.searchLocalEvents("");
    }

    @GetMapping("searchLocalEventWithID/{id}")
    public ArrayList<LocalEvent> searchLocalEventWithID(@PathVariable("id") String id) {
        AbstractLocalEventManagment localEventManagment = new LocalEventManagment(model, new SearchLocalEventsByID(),
                new AddNormalLocalEvent());
        return localEventManagment.searchLocalEvents(id);
    }

    @PostMapping("createAccount/{username}/{password}/{mail}/{phonenumber}")
    public User createAccount(@PathVariable("username") String userName, @PathVariable("password") String password,
            @PathVariable("mail") String mail, @PathVariable("phonenumber") String phoneNumber) {
        UserManagementCtrl ctrl = new UserManagementCtrl(new matchingValidation(),
                model, manager);

        return ctrl.Register(userName, password, mail, phoneNumber);
    }

    @PostMapping("login/{username}/{password}")
    public User login(@PathVariable("username") String username, @PathVariable("password") String password) {
        UserManagementCtrl ctrl = new UserManagementCtrl(new matchingValidation(),
                model, manager);
        return ctrl.login(username, password);
    }

    @PostMapping("logout/{id}")
    public User logout(@PathVariable("id") String id) {
        UserManagementCtrl ctrl = new UserManagementCtrl(new matchingValidation(),
                model, manager);
        return ctrl.logout(id);
    }

    @PostMapping("updatepassword/{id}/{newpass}")
    public User updatePassword(@PathVariable("id") String id, @PathVariable("newpass") String newpass) {
        UserManagementCtrl ctrl = new UserManagementCtrl(new matchingValidation(),
                model, manager);
        return ctrl.updatePassword(id, newpass);
    }

    @PostMapping("addHotelRoomBooking/{hotelRoomID}/{checkInDate}/{checkOutDate}/{userID}")
    public AbstractHotelRoomBooking addRoomBooking(@PathVariable("hotelRoomID") String hotelRoomID,
            @PathVariable("checkInDate") String checkInDate, @PathVariable("checkOutDate") String checkoutDate,
            @PathVariable("userID") String userID) {
        HotelRoom hotelRoom = searchID.getHotelRoomWithID(hotelRoomID);
        if (hotelRoom == null)
            return null;
        HotelRoomBookingCtrl ctrl = new HotelRoomBookingCtrl(model, manager);
        LocalDate firstDate = LocalDate.parse(checkInDate);
        LocalDate secondDate = LocalDate.parse(checkoutDate);
        AbstractHotelRoomBooking booking = ctrl.createBooking(hotelRoom, firstDate, secondDate,
                userID);
        return booking;
    }

    @DeleteMapping("cancelHotelRoomBooking/{id}")
    public boolean cancelHotelRoomBooking(@PathVariable("id") String id) {
        HotelRoomBookingCtrl ctrl = new HotelRoomBookingCtrl(model, manager);
        return ctrl.cancelBooking(id);
    }

    @PostMapping("addLocalEventBooking/{userid}/{localEventid}")
    public AbstractLocalEventBooking addLocalEventBooking(@PathVariable("userid") String userid,
            @PathVariable("localEventid") String localEventid) {
        LocalEventBookingCtrl ctrl = new LocalEventBookingCtrl(model, manager);
        LocalEvent event = searchID.getLocalEventWithID(localEventid);
        if (event == null)
            return null;
        AbstractLocalEventBooking booking = ctrl.createBooking(userid, event);
        return booking;
    }

    @DeleteMapping("cancelLocalEventBooking/{id}")
    public boolean cancelLocalEventBooking(@PathVariable("id") String id) {
        LocalEventBookingCtrl ctrl = new LocalEventBookingCtrl(model, manager);
        return ctrl.removeBooking(id);
    }

    @GetMapping("getUserNotifications/{id}")
    public ArrayList<Notification> getUserNotifications(@PathVariable("id") String id) {
        DashboardAbstract dashboard = new Dashboard(model, id, notifications);
        return dashboard.getNotifications();
    }

    @GetMapping("getUserHotelRoomBookings/{id}")
    public ArrayList<AbstractHotelRoomBooking> getUserHotelRoomBookings(@PathVariable("id") String id) {
        DashboardAbstract dashboard = new Dashboard(model, id, notifications);
        return dashboard.displayHotelRoomBooking();
    }

    @GetMapping("getUserLocalEventBookings/{id}")
    public ArrayList<AbstractLocalEventBooking> getUserLocalEventBookings(@PathVariable("id") String id) {
        DashboardAbstract dashboard = new Dashboard(model, id, notifications);
        return dashboard.displayLocalEventBooking();
    }

    @GetMapping("getUserRecommendations/{id}")
    public ArrayList<LocalEvent> getUserRecommendations(@PathVariable("id") String id) {
        DashboardAbstract dashboard = new Dashboard(model, id, notifications);
        return dashboard.getRecommendedEvents();
    }

    ///////////
    @GetMapping("getAllUsers")
    public ArrayList<User> getAllUsers() {
        return searchID.getAllUsers();
    }

    @GetMapping("getAllLocalEventBooking")
    public ArrayList<AbstractLocalEventBooking> getAllLocalEventBookings() {
        return searchID.getAllLocalEventBookings();
    }

    @GetMapping("getAllHotelRoomBooking")
    public ArrayList<AbstractHotelRoomBooking> getAllHotelRoomBookings() {
        return searchID.getAllHotelRoomBookings();
    }

    @GetMapping("getUser/{id}")
    public User getUser(@PathVariable("id") String id) {
        return searchID.getUserWithID(id);
    }

    @GetMapping("getHotelRoomBooking/{id}")
    public AbstractHotelRoomBooking getHotelRoomBooking(@PathVariable("id") String id) {
        return searchID.getHotelRoomBookingWithId(id);
    }

    @GetMapping("getLocalEventBooking/{id}")
    public AbstractLocalEventBooking getLocalEventBooking(@PathVariable("id") String id) {
        return searchID.getLocalEventBookingWithId(id);
    }

    @GetMapping("getNotification/{id}")
    public Notification getNotification(@PathVariable("id") String id) {
        return notifications.getByNotificationId(id);
    }

    @DeleteMapping("deleteNotification/{id}")
    public void deleteNotification(@PathVariable("id") String id) {
        notifications.removeByNotificationId(id);
    }

    @GetMapping("getAllNotifications")
    public ArrayList<Notification> geNotifications() {
        return notifications.getNotifications();
    }

    //////
    @PostMapping("addHotelRoom/{hotel}/{City}/{Address}/{Available}/{name}/{price}")
    public boolean addHotelRoom(
            @PathVariable("hotel") String hotel,
            @PathVariable("City") String city,
            @PathVariable("Address") String address,
            @PathVariable("Available") boolean available,
            @PathVariable("name") String name,
            @PathVariable("price") double price) {
        AbstractHotelManagment hotelManagment = new HotelManagment(model, new SearchHotelRoomsByName(),
                new AddStandardRoom());
        return hotelManagment.AddHotelRoom(hotel, city, address, available, name, price);
    }

    @DeleteMapping("deleteHotelRoom/{id}")
    public boolean deleteHotelRoom(@PathVariable("id") String id) {
        AbstractHotelManagment hotelManagment = new HotelManagment(model, new SearchHotelRoomsByName(),
                new AddStandardRoom());
        return hotelManagment.removeHotelRoom(id);
    }

    @PostMapping("addLocalEvent/{address}/{city}/{organizer}/{name}/{price}/{numOfTickets}")
    public boolean addEvent(
            @PathVariable("address") String address,
            @PathVariable("city") String city,
            @PathVariable("organizer") String organizer,
            @PathVariable("name") String name,
            @PathVariable("price") double price,
            @PathVariable("numOfTickets") int numOfTickets) {
        AbstractLocalEventManagment localEventManagment = new LocalEventManagment(model, new SearchLocalEventsByName(),
                new AddNormalLocalEvent());
        return localEventManagment.add(address, city, organizer, name, price, numOfTickets);
    }

    @DeleteMapping("deleteLocalEvent/{id}")
    public boolean deleteLocalEvent(@PathVariable("id") String id) {
        AbstractLocalEventManagment localEventManagment = new LocalEventManagment(model, new SearchLocalEventsByName(),
                new AddNormalLocalEvent());
        return localEventManagment.removeLocalEvent(id);
    }

    @GetMapping("getNotificationsStatistics")
    public String getStats() {
        String allStatistics = "General notification statistics: ";
        NotificationStatistics statistics = EmailNotificationStatistics.getInstance();
        allStatistics += "\n Most used template for all notification: " + statistics.getMostSentTemplate();
        allStatistics += "\n Number Of successfull: " + statistics.getNumberOfSuccessfull();
        allStatistics += "\n Number Of unsuccessfull: " + statistics.getNumberOfUnSuccessfull();
        allStatistics += "\n Most notified E-mail: " + statistics.getMostNotified();
        statistics = SMSNotificationStatistics.getInstance();
        allStatistics += "\n Most notified number: " + statistics.getMostNotified();
        statistics = DashboardNotificationStatistics.getInstance();
        allStatistics += "\n Most used template for dashboard: " + statistics.getMostNotified();
        return allStatistics;
    }
}
