package org.example;

import com.mongodb.client.*;
import org.bson.Document;

import org.bson.conversions.Bson;

public class MongoDB {
    public static void main( String[] args ) {

        String uri = "mongodb://127.0.0.1:27017";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("company");
            MongoCollection<Document> collection = database.getCollection("employee");

            MongoCursor<Document> cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                System.out.println("collection is " +cursor.next() );
            }

//            Document doc = collection.find().first();
//            if (doc != null) {
//                System.out.println(doc.toJson());
//            } else {
//                System.out.println("No matching documents found.");
//            }
        }
    }
}


