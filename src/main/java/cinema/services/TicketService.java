package cinema.services;

import cinema.models.Refund;
import cinema.models.Seat;
import cinema.models.Ticket;

import java.util.UUID;


public interface TicketService {
    Ticket purchase(Seat seat);
    Refund returnTicket(UUID token);
}
