package cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.UUID;

public final class Ticket {
    @Getter
    private final UUID token;
    @Getter
    private final Seat ticket;

    {
        token = UUID.randomUUID();
    }

    public Ticket(Seat ticket) {
        this.ticket = ticket;
    }

    @JsonIgnore
    public int getPrice() {
        return ticket.getPrice();
    }
}
