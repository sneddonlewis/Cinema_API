package cinema.repository.statistic.booking;

import cinema.model.Refund;
import cinema.model.Seat;
import cinema.model.Ticket;

import java.util.List;

public interface BookingRepo {
    Ticket bookSeats(List<Seat> seat);
    Refund cancelBooking(Ticket ticket);
}
