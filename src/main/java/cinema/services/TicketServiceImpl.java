package cinema.services;

import cinema.models.Refund;
import cinema.models.Seat;
import cinema.models.Ticket;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicketServiceImpl implements TicketService{
    private static final Map<UUID, Ticket> purchases;

    static {
        purchases = new HashMap<>();
    }

    @Override
    public Ticket purchase(Seat seat) {
        Ticket ticket = new Ticket(seat);
        purchases.put(ticket.getToken(), ticket);
        System.out.println("Purchases: " + purchases);
        return ticket;
    }

    @Override
    public Refund returnTicket(UUID token) {
        System.out.println("Returning token: " + token);
        if (!purchases.containsKey(token)) {
            throw new IllegalArgumentException("Wrong token!");
        }
        Ticket returned = purchases.get(token);
        freeUpSeat(token, returned);
        return new Refund(returned.getTicket());
    }

    private void freeUpSeat(UUID token, Ticket returned) {
        purchases.remove(token);
    }
}
