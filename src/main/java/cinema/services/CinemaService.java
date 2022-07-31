package cinema.services;

import cinema.model.*;

import java.util.UUID;

public interface CinemaService {
    Cinema showCinema();
    Ticket purchase(SeatPosition seat);
    Refund returnTicket(UUID token);
    Statistics getStatistics();
}
