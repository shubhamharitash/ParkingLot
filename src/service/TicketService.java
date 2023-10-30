package service;

import dto.ParkingSlot;
import dto.Ticket;
import dto.Vehicle;
import repository.TicketRepository;

public class TicketService {

    static Ticket generateTicket(ParkingSlot parkingSlot, Vehicle vehicle){
        String ticket_id=generateTicketId(parkingSlot);
        Ticket ticket=new Ticket(ticket_id,parkingSlot,vehicle);
        TicketRepository.getTicketMap().put(ticket_id,ticket);
        return ticket;
    }

    static String generateTicketId(ParkingSlot parkingSlot){
        return String.valueOf(parkingSlot.getParkingLot()+"_"+parkingSlot.getParkingFloor()+"_"+parkingSlot.getId());
    }
    static Ticket getTicketByTicketId(String ticketId){
        if (!TicketRepository.getTicketMap().containsKey(ticketId))
            throw new RuntimeException("INVALID TICKET");
        return TicketRepository.getTicketMap().get(ticketId);
    }
    static void deleteTicket(String ticketId){
        TicketRepository.getTicketMap().remove(ticketId);
    }
}
