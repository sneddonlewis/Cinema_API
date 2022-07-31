package cinema.data;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDatabase;
import com.arangodb.DbName;
import com.arangodb.mapping.ArangoJack;

public class ArangoDb {

    private static ArangoDatabase instance;

    public static ArangoDatabase getInstance() {
        if (instance == null) {
            ArangoDB arangoDB = new ArangoDB.Builder()
                    .serializer(new ArangoJack())
                    .password("root")
                    .build();
            instance = arangoDB.db(DbName.of("Cinema"));
            return instance;
        }
        return instance;
    }
}
