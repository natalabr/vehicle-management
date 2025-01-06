package model;

import persistence.Role;
import persistence.User;

import java.util.ArrayList;
import java.util.List;

public class UserModel {

    private List<User> users = new ArrayList<>();

    public UserModel() {

        User user1 = new User();
        user1.role = Role.CUSTOMER_ADVISER;
        user1.firstname = "Linda";
        user1.lastname = "Rue";
        user1.username = "linda";
        user1.password = "linda12345";

        User user2 = new User();
        user2.role = Role.VEHICLE_MANAGER;
        user2.firstname = "Bob";
        user2.lastname = "Marley";
        user2.username = "bob";
        user2.password = "bob12345";

        User user3 = new User();
        user3.role = Role.ADMIN;
        user3.firstname = "John";
        user3.lastname = "Smith";
        user3.username = "john";
        user3.password = "john12345";

        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.username.compareToIgnoreCase(username) == 0) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void deleteUser(String username) {
        for (User user : users) {
            if (user.username == username) {
                users.remove(user);
                break;
            }
        }
    }

    public void editUser(User user) {
        for (User currentUser : users) {
            if (currentUser.username == user.username) {
                users.remove(currentUser);
                users.add(user);
                break;
            }
        }
    }
}
