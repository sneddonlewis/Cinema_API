package cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Ticket {
    private final UUID token;
    private final Seat ticket;

    {
        token = UUID.randomUUID();
    }

    public Ticket(Seat ticket) {
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public Seat getTicket() {
        return ticket;
    }

    @JsonIgnore
    public int getPrice() {
        return ticket.getPrice();
    }
}
