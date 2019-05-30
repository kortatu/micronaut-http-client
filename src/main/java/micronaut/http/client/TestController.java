package micronaut.http.client;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Controller("/test")
public class TestController {

    private KafkaToMongo kafkaToMongo;

    public TestController(KafkaToMongo kafkaToMongo) {
        this.kafkaToMongo = kafkaToMongo;
    }

    @Get(value = "/nonblocking", produces = MediaType.APPLICATION_JSON)
    public Flowable<KafkaMessage> greetsIp() {
        long randomIp = Math.round(Math.random() * 255);
        return this.kafkaToMongo.findByIp("192.168.0." + randomIp);
    }

    @Get(value = "/blocking", produces = MediaType.APPLICATION_JSON)
    public Iterable<KafkaMessage> greetsIpB() {
        long randomIp = Math.round(Math.random() * 255);
        return this.kafkaToMongo.findByIpB("192.168.0." + randomIp);
    }

    @Get(value = "/mixedbnb", produces = MediaType.APPLICATION_JSON)
    public Iterable<KafkaMessage> greetsIpBNB() {
        long randomIp = Math.round(Math.random() * 255);
        return this.kafkaToMongo.findByIp("192.168.0." + randomIp).blockingIterable();
    }

    @Get(value = "/mixednbb", produces = MediaType.APPLICATION_JSON)
    public Flowable<KafkaMessage> greetsIpNBB() {
        long randomIp = Math.round(Math.random() * 255);
        return this.kafkaToMongo.findByIp("192.168.0." + randomIp);
    }

    @Get(value = "/search/byIp/{ip}", produces = MediaType.APPLICATION_JSON)
    public Flowable<KafkaMessage> findByIp(String ip) {
        return this.kafkaToMongo.findByIp(ip);
    }

    @Post(value = "/generate/{ip}", produces = MediaType.APPLICATION_JSON)
    public Single<KafkaMessage> generate(String ip) {
        return Single.just(new KafkaMessage(ip, "Auto-generated", null));
    }
}
