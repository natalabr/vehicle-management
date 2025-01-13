package persistence;

public class User {

    public Role role;
    public String lastname;
    public String firstname;
    public String username;
    public String password;

    public String toString() {
        return lastname + " " + firstname;
    }
}
