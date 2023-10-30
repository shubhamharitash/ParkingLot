package dto;

import enums.VehicleType;

public class Ticket {
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    ParkingSlot parkingSlot;

    public Ticket(String id, ParkingSlot parkingSlot, Vehicle vehicle) {
        this.id = id;
        this.parkingSlot = parkingSlot;
        this.vehicle = vehicle;
    }

    Vehicle vehicle;
}
