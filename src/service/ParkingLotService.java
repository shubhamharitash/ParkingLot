package service;

import dto.*;
import enums.DisplayType;
import enums.ParkingSlotStatus;
import enums.VehicleType;
import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {
    //display_type: free_count, free_slots, occupied_slots
    //display <display_type> <vehicle_type>
    List<ParkingLot> parkingLotList=ParkingLotRepository.getParkingLotList();


   public void create_parkingLot(String parking_lot_id ,int no_of_floors,int no_of_slots_per_floor){
       List<ParkingFloor> parkingFloorList=new ArrayList<>(no_of_floors);
       for (int i=0;i<no_of_floors;i++){
           List<ParkingSlot> parkingSlotList=new ArrayList<>(no_of_slots_per_floor);
           for (int j=0;j<no_of_slots_per_floor;j++){
               ParkingSlot parkingSlot=new ParkingSlot(String.valueOf(j+1),VehicleType.CAR,ParkingSlotStatus.AVAILABLE,parking_lot_id,i+1);
               if (j==0){
                   parkingSlot.setVehicleType(VehicleType.TRUCK);
               }else if(j==1 || j==2){
                   parkingSlot.setVehicleType(VehicleType.BIKE);
               }
               parkingSlotList.add(parkingSlot);
           }
           ParkingFloor parkingFloor=new ParkingFloor(i+1,parking_lot_id,parkingSlotList);
           parkingFloorList.add(parkingFloor);
       }
        ParkingLot parkingLot=new ParkingLot(parking_lot_id,no_of_floors,no_of_slots_per_floor,parkingFloorList);
        ParkingLotRepository.getParkingSlotRepositoryMap().put(parking_lot_id,parkingLot);
        ParkingLotRepository.getParkingLotList().add(parkingLot);
       System.out.println("Created parking lot with "+no_of_floors+" floors and "+no_of_slots_per_floor+" slots per floor");
    }
   public void park_vehicle(Vehicle vehicle){
       ParkingLot parkingLot=parkingLotList.get(0);
        List<ParkingFloor> parkingFloorList=parkingLot.getParkingFloorList();
        int parkingFloorIndex=0;
        int floorFullCount=0;
        for (ParkingFloor parkingFloor:parkingFloorList) {
            parkingFloorIndex++;
            if (ParkingFloorService.getFreeSlotsCount(parkingFloor,vehicle.getVehicleType())>0){
              Ticket allotmentTicket=ParkingFloorService.allotSlot(parkingFloor,vehicle);
                if (allotmentTicket!=null){
                    System.out.println("Parked vehicle. Ticket ID: "+allotmentTicket.getId());
                    break;
                }
            }else {
               floorFullCount++;
            }
        }
        if (floorFullCount==parkingFloorList.size()){
            System.out.println("Parking Lot Full");
        }
    }

   public void unpark_vehicle(String ticketId){
       ParkingLot parkingLot=parkingLotList.get(0);
        Ticket ticket=TicketService.getTicketByTicketId(ticketId);
        ParkingSlot parkingSlot=ticket.getParkingSlot();
        Vehicle vehicle= ticket.getVehicle();
        ParkingSlotService parkingSlotService=new ParkingSlotService(parkingSlot);
        parkingSlotService.unallotSlot(parkingSlot,vehicle);
        TicketService.deleteTicket(ticketId);
       System.out.println("Unparked vehicle with Registration Number: "+vehicle.getRegNo()+" and Color: "+vehicle.getColor());

    }

   public void display(DisplayType displayType, VehicleType vehicleType){
       ParkingLot parkingLot=parkingLotList.get(0);
        List<ParkingFloor> parkingFloorList=parkingLot.getParkingFloorList();
        int parkingFloorIndex=0;
        for (ParkingFloor parkingFloor:parkingFloorList) {
            parkingFloorIndex++;
            if(displayType.equals(DisplayType.free_count)) {
                int freeSLotsCount = ParkingFloorService.getFreeSlotsCount(parkingFloor,vehicleType);
                System.out.println("No. of free slots for " + vehicleType + " on Floor " + parkingFloorIndex + ":" + freeSLotsCount);
            }else if (displayType.equals(DisplayType.free_slots)){
                System.out.print("Free slots for "+ vehicleType+" on Floor "+parkingFloorIndex+": ");
                ParkingFloorService.getFreeSlots( parkingFloor,vehicleType);
                System.out.println();
            }else if (displayType.equals(DisplayType.occupied_slots)){
                System.out.print("Occupied slots for "+ vehicleType+"on Floor "+parkingFloorIndex+": ");
                ParkingFloorService.getOccupiedSlots(parkingFloor, vehicleType);
                System.out.println();
            }
        }
    }

}
