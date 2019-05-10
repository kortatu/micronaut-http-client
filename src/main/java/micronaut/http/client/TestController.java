package micronaut.http.client;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Flowable;

@Controller("/test")
public class TestController {

    private KafkaToMongo kafkaToMongo;

    public TestController(KafkaToMongo kafkaToMongo) {
        this.kafkaToMongo = kafkaToMongo;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public Flowable<KafkaMessage> greetsIp() {
        long randomIp = Math.round(Math.random() * 255);
        return this.kafkaToMongo.findByIp("192.168.0." + randomIp);
    }
}
