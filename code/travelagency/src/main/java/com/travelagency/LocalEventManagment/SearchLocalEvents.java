package com.travelagency.LocalEventManagment;

import java.util.ArrayList;
import com.travelagency.model.*;

public interface SearchLocalEvents {
    ArrayList<LocalEvent> searchLocalEvents(String text, Model model);
}
