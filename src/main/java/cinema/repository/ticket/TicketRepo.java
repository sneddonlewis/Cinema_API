package cinema.repository.ticket;

import cinema.models.Refund;
import cinema.models.SeatPosition;
import cinema.models.Ticket;

import java.util.UUID;

public interface TicketRepo {
    Ticket purchaseSeat(SeatPosition seat);
    Refund refundTicket(UUID token);
}
