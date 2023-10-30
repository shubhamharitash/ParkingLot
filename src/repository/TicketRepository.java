package repository;

import dto.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    public TicketRepository() {
        ticketMap=new HashMap<>();
    }

    public static Map<String, Ticket> getTicketMap() {
        return ticketMap;
    }

    static Map<String, Ticket> ticketMap;
}
