package cinema.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Refund {
    @JsonProperty("returned_ticket")
    private final Seat returnedTicket;

    public Refund(Seat returnedTicket) {
        this.returnedTicket = returnedTicket;
    }

    public Seat getReturnedTicket() {
        return returnedTicket;
    }
}
