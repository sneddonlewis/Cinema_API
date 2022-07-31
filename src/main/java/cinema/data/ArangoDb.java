package cinema.data;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDatabase;
import com.arangodb.DbName;
import com.arangodb.mapping.ArangoJack;

public class ArangoDb {
    ArangoDatabase arangoDatabase() {
        ArangoDB arangoDB = new ArangoDB.Builder()
                .serializer(new ArangoJack())
                .password("root")
                .build();
        var db = arangoDB.db(DbName.of("Cinema"));
        return db;
    }
}
