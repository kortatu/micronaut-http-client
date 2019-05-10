package micronaut.http.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.CircuitBreaker;
import io.reactivex.Flowable;

import javax.validation.constraints.NotBlank;

@Client("kafka-to-mongo")
@CircuitBreaker
public interface KafkaToMongo {

    @Get("/messages/search/byIp/{ip}")
    Flowable<KafkaMessage> findByIp(@NotBlank String ip);
}
