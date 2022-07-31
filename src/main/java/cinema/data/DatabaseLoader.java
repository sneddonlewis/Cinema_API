package cinema.data;

import com.arangodb.ArangoCollection;
import com.arangodb.ArangoDatabase;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        var db = new ArangoDb().arangoDatabase();

        if (!db.exists()) {
            db.create();
            createCollections(db);
        }
    }

    private static void createCollections(ArangoDatabase db) {
        db = createCollection(db, "Seats");
        db = createCollection(db, "Tickets");
        db = createCollection(db, "Income");
        db = createCollection(db, "Returns");

        // Populate Seats
    }

    private static ArangoDatabase createCollection(ArangoDatabase db, String clxName) {
        ArangoCollection collection = db.collection(clxName);
        collection.create();
        System.out.print("Created collection: ");
        System.out.println(clxName);
        return db;
    }
}
