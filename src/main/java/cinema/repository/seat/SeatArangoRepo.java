package cinema.repository.seat;

import cinema.data.ArangoDb;
import cinema.model.Seat;
import cinema.repository.DbCollections;
import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatArangoRepo implements SeatRepo {

    private final ArangoDatabase _db;
    private static final String clx = DbCollections.SeatClx();

    public SeatArangoRepo() {
        _db = ArangoDb.getInstance();
    }

    @Override
    public List<Seat> allSeats() {
        String query = "FOR doc IN Seats RETURN doc";
        ArangoCursor<BaseDocument> cursor = _db.query(query, null, null, BaseDocument.class);
        cursor.forEach(aDocument -> System.out.println("Key: " + aDocument.getKey()));
        return null;
    }

    @Override
    public List<Seat> availableSeats() {
        return null;
    }
}
