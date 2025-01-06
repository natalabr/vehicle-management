package controller;

import model.UserModel;
import persistence.User;

public class LoginController {

    private UserModel userModel = new UserModel();

    public User Login(String username, String password) {

        User user = userModel.getUser(username);

        if (user == null) {
            return null;
        }

        if (user.password.compareTo(password) == 0) {
            return user;
        }
        return null;
    }


}
