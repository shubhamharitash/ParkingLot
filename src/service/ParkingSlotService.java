package service;

import dto.ParkingSlot;
import dto.Ticket;
import dto.Vehicle;
import enums.ParkingSlotStatus;

public class ParkingSlotService {

    public ParkingSlotService(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    ParkingSlot parkingSlot;
     Ticket allotSlot(ParkingSlot parkingSlot, Vehicle vehicle){
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.UNAVAIALBLE);
         Ticket ticket=TicketService.generateTicket(parkingSlot,vehicle);
        parkingSlot.setTicket(ticket);
        return ticket;
    }
     void unallotSlot(ParkingSlot parkingSlot, Vehicle vehicle){
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.AVAILABLE);
        parkingSlot.setTicket(null);
    }

}
