package cinema.repository.seat;

import cinema.models.Seat;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDatabase;
import com.arangodb.DbName;
import com.arangodb.mapping.ArangoJack;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatRepoImpl implements SeatRepo{

    private final ArangoDatabase _db;

    public SeatRepoImpl() {
        ArangoDB arangoDB = new ArangoDB.Builder()
                .serializer(new ArangoJack())
                .password("ke7p5zE1G89pKPO4")
                .build();
        _db = arangoDB.db(DbName.of("Cinema"));
    }

    @Override
    public List<Seat> allSeats() {
        return null;
    }

    @Override
    public List<Seat> availableSeats() {
        return null;
    }
}
