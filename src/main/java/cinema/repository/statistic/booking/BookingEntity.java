package cinema.repository.statistic.booking;

import cinema.repository.seat.SeatEntity;
import com.arangodb.entity.BaseDocument;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class BookingEntity extends BaseDocument {
    private UUID ticketId;
    private SeatEntity seat;
}
