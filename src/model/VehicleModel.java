package model;

import persistence.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleModel {

    List<Vehicle> vehicles = new ArrayList<>();

    public VehicleModel() {

        Vehicle vehicle1 = new Vehicle();
        vehicle1.brand = "Nissan";
        vehicle1.model = "Skyline r34";

        Vehicle vehicle2 = new Vehicle();
        vehicle2.brand = "Audi";
        vehicle2.model = "A4";

        Vehicle vehicle3 = new Vehicle();
        vehicle3.brand = "Opel";
        vehicle3.model = "Astra";

        Vehicle vehicle4 = new Vehicle();
        vehicle4.brand = "Nissan";
        vehicle4.model = "Qashqai";

        Vehicle vehicle5 = new Vehicle();
        vehicle5.brand = "Audi";
        vehicle5.model = "A5";

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);
        vehicles.add(vehicle4);
        vehicles.add(vehicle5);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

}
