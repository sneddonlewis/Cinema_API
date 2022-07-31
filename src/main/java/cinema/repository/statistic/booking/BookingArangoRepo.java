package cinema.repository.statistic.booking;

import cinema.data.ArangoDb;
import cinema.model.Refund;
import cinema.model.Seat;
import cinema.model.Ticket;
import com.arangodb.ArangoDatabase;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BookingArangoRepo implements BookingRepo {

    private final ArangoDatabase _db;

    public BookingArangoRepo() {
        this._db = ArangoDb.getInstance();
    }

    @Override
    public Ticket bookSeats(List<Seat> seats) {
        // check all seats are free
        // create a booking
        // create hasBooking edges to all seats
        // return ticket
        UUID ticketId = UUID.randomUUID();
        Map<String, Object> bindVars = Map.of("seats", seats, "ticketId", ticketId);

        return null;
    }

    @Override
    public Refund cancelBooking(Ticket ticket) {
        return null;
    }
}
