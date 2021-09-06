package cinema.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class Refund {
    @JsonProperty("returned_ticket")
    private final Seat returnedTicket;
}
