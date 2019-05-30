package micronaut.http.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class KafkaMessage {
    public String name;
    public String ip;
    public String id;

    @JsonCreator
    public KafkaMessage(@JsonProperty("name") String name,
                        @JsonProperty("ip") String ip,
                        @JsonProperty("id") String id) {
        this.name = name;
        this.ip = ip;
        this.id = id;
    }
}
