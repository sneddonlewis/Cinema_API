package cinema.data;

import cinema.model.Cinema;
import com.arangodb.ArangoCollection;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseLoader implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        var db = ArangoDb.getInstance();

        if (!db.exists()) {
            db.create();
            createCollections(db);
        }
    }

    private static void createCollections(ArangoDatabase db) {
        var seatClx = createCollection(db, "Seats");
        var ticketClx = createCollection(db, "Tickets");
        var incomeClx = createCollection(db, "Income");
        var returnsClx = createCollection(db, "Returns");

        // Populate Seats
        Cinema screen = Cinema.getInstance();
        var seats = screen.getAvailableSeats();
        var screenName = "default";
        for (var seat : seats) {
            var doc = new BaseDocument();
            doc.addAttribute("screenName", screenName);
            doc.addAttribute("row", seat.getRow());
            doc.addAttribute("column", seat.getColumn());
            doc.addAttribute("price", seat.getPrice());
            doc.addAttribute("isBooked", false);
            seatClx.insertDocument(doc);
        }
    }

    private static ArangoCollection createCollection(ArangoDatabase db, String clxName) {
        ArangoCollection collection = db.collection(clxName);
        collection.create();
        System.out.print("Created collection: ");
        System.out.println(clxName);
        return collection;
    }
}
