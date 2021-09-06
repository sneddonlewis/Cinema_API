package cinema.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class Statistics {
    @JsonProperty("current_income")
    int currentIncome;
    @JsonProperty("number_of_available_seats")
    int availableSeats;
    @JsonProperty("number_of_purchased_tickets")
    int purchasedTickets;
}
