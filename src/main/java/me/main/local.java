package me.main;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

public class local {
    static String entry;
    public static void main(String[] args) {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://braden:1234@cluster0.w4snx.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("chat");
        MongoCollection<Document> collection = database.getCollection("chat");
        ArrayList<Document> inserts = new ArrayList<>();
        FindIterable<Document> iterDoc = collection.find();
        while (true) {
            for (Document document : iterDoc) {
                if (document == null) {
                    return;
                } else {
                    if (!inserts.contains(document)) {
                        inserts.add(document);
                        System.out.println(document.get("message").toString());
                        entry = document.get("message").toString();
                    }
                }
            }
        }
    }

}
