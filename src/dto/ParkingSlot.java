package dto;

import enums.ParkingSlotStatus;
import enums.VehicleType;

public class ParkingSlot {
    String id;
    VehicleType vehicleType;
    ParkingSlotStatus parkingSlotStatus;
    String parkingLot;
    int parkingFloorNumber;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    Ticket ticket;

    public ParkingSlot(String id, VehicleType vehicleType, ParkingSlotStatus parkingSlotStatus, String parkingLot_id, int parkingFloorNumber) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.parkingSlotStatus = parkingSlotStatus;
        this.parkingLot = parkingLot_id;
        this.parkingFloorNumber = parkingFloorNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public String getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(String parkingLot_id) {
        this.parkingLot = parkingLot;
    }

    public int getParkingFloor() {
        return parkingFloorNumber;
    }

    public void setParkingFloor(int parkingFloorNumber) {
        this.parkingFloorNumber = parkingFloorNumber;
    }
}
