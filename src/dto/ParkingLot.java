package dto;

import java.util.List;

public class ParkingLot {
    String id;
    int noOfFloors;
    int noOfSlotsPerFloor;
    List<ParkingFloor> parkingFloorList;

    public ParkingLot(String id, int noOfFloors, int noOfSlotsPerFloor, List<ParkingFloor> parkingFloorList) {
        this.id = id;
        this.noOfFloors = noOfFloors;
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
        this.parkingFloorList = parkingFloorList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    public int getNoOfSlotsPerFloor() {
        return noOfSlotsPerFloor;
    }

    public void setNoOfSlotsPerFloor(int noOfSlotsPerFloor) {
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
    }

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }
}
