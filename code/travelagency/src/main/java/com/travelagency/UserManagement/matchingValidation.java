package com.travelagency.UserManagement;

import java.util.ArrayList;
import com.travelagency.model.User;

public class matchingValidation implements IValidate {

    @Override
    public User validateCredentials(String userName, String password, ArrayList<User> users) {
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            String name = users.get(i).getUsername();
            String pass = users.get(i).getPassword();
            if (userName.equals(name) && password.equals(pass)) {
                user = users.get(i);
            }
        }
        return user;
    }

}