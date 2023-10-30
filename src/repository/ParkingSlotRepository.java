package repository;

import dto.ParkingSlot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSlotRepository {
    public ParkingSlotRepository() {
        parkingSlotMap=new HashMap<>();
    }

    public static Map<String, ParkingSlot> getParkingSlotMap() {
        return parkingSlotMap;
    }

    static Map<String, ParkingSlot> parkingSlotMap;
}
