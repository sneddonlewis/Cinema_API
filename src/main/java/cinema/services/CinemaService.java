package cinema.services;

import cinema.model.*;

import java.util.List;
import java.util.UUID;

public interface CinemaService {
    Cinema showCinema();
    List<Seat> allSeats();
    List<Seat> availableSeats();
    Ticket purchase(SeatPosition seat);
    Refund returnTicket(UUID token);
    Statistics getStatistics();
}
