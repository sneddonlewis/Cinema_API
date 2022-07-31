package cinema.repository.ticket;

import cinema.model.Refund;
import cinema.model.SeatPosition;
import cinema.model.Ticket;

import java.util.UUID;

public interface TicketRepo {
    Ticket purchaseSeat(SeatPosition seat);
    Refund refundTicket(UUID token);
}
