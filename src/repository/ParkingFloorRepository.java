package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloorRepository {
    public static Map<String, ParkingFloorRepository> getParkingFloorRepositoryMap() {
        return parkingFloorRepositoryMap;
    }

    static Map<String,ParkingFloorRepository> parkingFloorRepositoryMap;

    public ParkingFloorRepository() {
        parkingFloorRepositoryMap=new HashMap<>();
    }
}
