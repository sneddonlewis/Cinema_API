package cinema.services;

import cinema.exceptions.IllegalSeatException;
import cinema.exceptions.UnavailableSeatException;
import cinema.models.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class CinemaServiceImpl implements CinemaService{
    private static final Cinema cinema;
    private static final Map<UUID, Ticket> purchases;

    static {
        cinema = Cinema.getInstance();
        purchases = new HashMap<>();
    }

    @Override
    public Cinema showCinema() {
        return cinema;
    }

    @Override
    public Ticket purchase(SeatPosition seat) {
        int index = cinema.calculateIndexFromPosition(seat.getRow(), seat.getColumn());
        if (
            cinema.getTotalRows() < seat.getRow() ||
            cinema.getTotalRows() < seat.getColumn()
        ) {
            throw new IllegalSeatException();
        }
        Seat purchaseRequest;
        try {
            purchaseRequest = cinema.getAvailableSeats()[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalSeatException();
        }
        boolean success = cinema.purchaseSeat(index);
        if (success) {
            Ticket ticket = new Ticket(purchaseRequest);
            purchases.put(ticket.getToken(), ticket);
            return ticket;
        }
        throw new UnavailableSeatException();
    }

    @Override
    public Refund returnTicket(UUID token) {
        if (!purchases.containsKey(token)) {
            throw new IllegalArgumentException("Wrong token!");
        }
        Ticket returned = purchases.get(token);
        freeUpSeat(token, returned);
        return new Refund(returned.getTicket());
    }

    @Override
    public Statistics getStatistics() {
        return new Statistics(getIncome(), getSeatsFreeCount(), getPurchasedSeatsCount());
    }

    private int getIncome() {
        return purchases
                .values()
                .stream()
                .mapToInt(Ticket::getPrice)
                .reduce(0, Integer::sum);
    }

    private int getSeatsFreeCount() {
        return cinema.getAvailableSeats().length - purchases.size();
    }

    private int getPurchasedSeatsCount() {
        return purchases.size();
    }

    private void freeUpSeat(UUID token, Ticket returned) {
        cinema.releaseSeat(returned.getTicket());
        purchases.remove(token);
    }
}
