package cinema.repository.seat;

import com.arangodb.entity.BaseDocument;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SeatEntity extends BaseDocument {
    private String screenName;
    private int row;
    private int column;
    private int price;
    private boolean isBooked;
}
