package service;

import dto.ParkingFloor;
import dto.ParkingSlot;
import dto.Ticket;
import dto.Vehicle;
import enums.DisplayType;
import enums.ParkingSlotStatus;
import enums.VehicleType;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingFloorService {

    static int getFreeSlotsCount( ParkingFloor parkingFloor,VehicleType vehicleType){
        List<ParkingSlot> parkingSlotList=parkingFloor.getParkingSlotList();
        int count= (int) parkingSlotList.stream().filter(parkingSlot -> parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)
                && parkingSlot.getVehicleType().equals(vehicleType)).count();
        return count;
    }
    static void getFreeSlots( ParkingFloor parkingFloor,VehicleType vehicleType){
        List<ParkingSlot> parkingSlotList=parkingFloor.getParkingSlotList();
        parkingSlotList.stream().filter(parkingSlot -> parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)
                && parkingSlot.getVehicleType().equals(vehicleType)).forEach(e-> System.out.print(e.getId()+","));
    }
    static void getOccupiedSlots(ParkingFloor parkingFloor,VehicleType vehicleType){
        List<ParkingSlot> parkingSlotList=parkingFloor.getParkingSlotList();
        parkingSlotList.stream().filter(parkingSlot -> parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.UNAVAIALBLE)
                && parkingSlot.getVehicleType().equals(vehicleType)).forEach(e-> System.out.print(e.getId()+","));
    }
    static Ticket allotSlot(ParkingFloor parkingFloor, Vehicle vehicle){
        List<ParkingSlot> parkingSlotList=parkingFloor.getParkingSlotList();
        List<ParkingSlot> availableParkingSlots=parkingSlotList.stream().filter(parkingSlot -> parkingSlot.getParkingSlotStatus().
                equals(ParkingSlotStatus.AVAILABLE) && parkingSlot.getVehicleType().equals(vehicle.getVehicleType())).collect(Collectors.toList());
        if (!availableParkingSlots.isEmpty()){
            ParkingSlot parkingSlot=availableParkingSlots.get(0);
            ParkingSlotService parkingSlotService=new ParkingSlotService(parkingSlot);
           Ticket ticket= parkingSlotService.allotSlot(parkingSlot,vehicle);
            return ticket;
        }else {
            return null;
        }
    }
}
