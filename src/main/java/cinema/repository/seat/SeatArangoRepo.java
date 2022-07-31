package cinema.repository.seat;

import cinema.data.ArangoDb;
import cinema.model.Seat;
import cinema.repository.DbCollections;
import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDatabase;
import com.arangodb.model.AqlQueryOptions;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class SeatArangoRepo implements SeatRepo {

    private final ArangoDatabase _db;

    public SeatArangoRepo() {
        _db = ArangoDb.getInstance();
    }

    @Override
    public List<Seat> allSeats() {
        String query = "FOR doc IN @@clx RETURN doc";
        return executeDocQuery(query);
    }

    @Override
    public List<Seat> availableSeats() {
        String query = "FOR doc IN @@clx FILTER doc.isBooked == false RETURN doc";
        return executeDocQuery(query);
    }

    private List<Seat> executeDocQuery(String query) {
        Map<String, Object> bindVars = Collections.singletonMap("@clx", DbCollections.SeatClx());

        ArangoCursor<SeatEntity> cursor = _db.query(
                query,
                bindVars,
                new AqlQueryOptions(),
                SeatEntity.class);

        return cursor
                .stream()
                .map(Seat::new)
                .collect(Collectors.toList());
    }
}
