package repository;

import dto.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {
    static Map<String, ParkingLot> parkingSlotRepositoryMap;

    public static List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    static List<ParkingLot> parkingLotList;

    public ParkingLotRepository() {
       parkingSlotRepositoryMap = new HashMap<>();
       parkingLotList=new ArrayList<>();
    }

    public static Map<String, ParkingLot> getParkingSlotRepositoryMap() {
        return parkingSlotRepositoryMap;
    }

}
