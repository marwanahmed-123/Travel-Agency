package com.travelagency.Booking;

import java.util.ArrayList;

import com.travelagency.model.*;

public interface IrecommendEvents {
    public ArrayList<LocalEvent> recommendEvents(String text, Model model);
}
