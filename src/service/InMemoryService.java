package service;

import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSlotRepository;
import repository.TicketRepository;

public class InMemoryService {
    public InMemoryService() {
        ParkingLotRepository parkingLotRepository=new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository=new ParkingFloorRepository();
        ParkingSlotRepository parkingSlotRepository=new ParkingSlotRepository();
        TicketRepository ticketRepository=new TicketRepository();
    }
}
