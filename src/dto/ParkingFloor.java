package dto;

import java.util.List;

public class ParkingFloor {
    int floorNumber;
    String parkingLot_id;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getParkingLot() {
        return parkingLot_id;
    }

    public void setParkingLot(String parkingLot_id) {
        this.parkingLot_id = parkingLot_id;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }

    List<ParkingSlot> parkingSlotList;

    public ParkingFloor(int floorNumber, String parkingLot_id, List<ParkingSlot> parkingSlotList) {
        this.floorNumber = floorNumber;
        this.parkingLot_id = parkingLot_id;
        this.parkingSlotList = parkingSlotList;
    }
}
