package me.main;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import io.github.cdimascio.dotenv.Dotenv;
import jssc.SerialPort;
import org.bson.Document;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class variables {

    static ConnectionString connectionString = new ConnectionString("mongodb+srv://braden:1234@cluster0.w4snx.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
    static MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
    static MongoClient mongoClient = MongoClients.create(settings);
    static MongoDatabase database = mongoClient.getDatabase("chat");
    static MongoCollection<Document> collection = database.getCollection("chat");
    static ArrayList<Document> inserts = new ArrayList<>();
    static FindIterable<Document> iterDoc = collection.find();

    static Dotenv dotenv = Dotenv.configure().load();
    static SerialPort com;

    static String entry;

    //static String recentEntry;
    static String port = methods.getEnvVariable("port"); // replace com5 with port
    static boolean state;
    static boolean isDead;
    static String lookingAt;

    static String recentEntry;

    static boolean power;

    static boolean walk;
    static boolean sight;
    static boolean click;
    static boolean brek;
    static boolean damage;
    static boolean death;
    static boolean respawn;

    static Inventory gui;

    static boolean inwater;
}
