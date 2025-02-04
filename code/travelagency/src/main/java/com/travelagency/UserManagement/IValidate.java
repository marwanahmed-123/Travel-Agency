package com.travelagency.UserManagement;
import java.util.ArrayList;
import com.travelagency.model.User;

public interface IValidate {
    public User validateCredentials(String userName, String password, ArrayList<User>users);
}
