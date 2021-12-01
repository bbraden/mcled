package me.braden;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import jssc.SerialPortException;
import org.bson.Document;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.mongodb.client.model.Filters.eq;
import static me.braden.methods.*;
import static me.braden.variables.*;

public class runnables {
    public static class MyTask extends BukkitRunnable {

        private int countdown;

        public MyTask() {
            this.countdown = 2;
        }

        @Override
        public void run() {
            if (countdown <= 0) {
                System.out.println("[-] countdown over");
                if (!isDead) {
                    try {
                        if (inwater) {
                            turnBlue(com);
                        }
                        else {
                            turnGreen(com);
                        }
                    } catch (SerialPortException e) {
                        e.printStackTrace();
                    }
                }
                this.cancel();
                return;
            }

            System.out.println("[+] " + countdown);
            countdown--;

        }
    }
    public static class mongo extends BukkitRunnable {

        @Override
        public void run() {
            List<Document> inserts = new ArrayList<>();
            ConnectionString connectionString = new ConnectionString("mongodb+srv://braden:1234@cluster0.w4snx.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connectionString)
                    .build();
            MongoClient mongoClient = MongoClients.create(settings);
            MongoDatabase database = mongoClient.getDatabase("chat");
            MongoCollection<Document> collection = database.getCollection("chat");
            FindIterable<Document> findIterable = collection.find(new Document());
            Document myDoc = collection.find(eq("message", "no ur sus")).first();
            String json = myDoc.toJson();
            FindIterable<Document> iterDoc = collection.find();
            while (true) {
                for (Document document : iterDoc) {
                    if (document == null) {
                        return;
                    } else {
                        if (!inserts.contains(document)) {
                            inserts.add(document);
                            System.out.println(document.get("message").toString());
                            recentEntry = document.get("message").toString();
                        }
                    }


                }
            }
        }
    }

    public static class mongoChecker extends BukkitRunnable {

        @Override
        public void run() {
            while (true) {
                System.out.println("tried");
                if (Objects.equals(recentEntry, "red")) {
                    try {
                        turnRed(com);
                    } catch (SerialPortException e) {
                        e.printStackTrace();
                    }
            }
            }
        }
    }
}
