package persistence;

public enum Role {
    ADMIN ("Admin"),
    CUSTOMER_ADVISER ("Customer Adviser"),
    VEHICLE_MANAGER ("Vehicle Manager");

    private final String name;
    private Role(String name) {
        this.name = name;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
