package cinema.repository.seat;

import cinema.models.Seat;

import java.util.List;

public interface SeatRepo {
    List<Seat> allSeats();
    List<Seat> availableSeats();
}
