package micronaut.http.client;

public class KafkaMessage {
    public String name;
    public String ip;
    public String id;

    public KafkaMessage() {
        //For Jackson and Bson
    }
}
