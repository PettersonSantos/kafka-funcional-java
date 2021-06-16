package br.com.petterson.funcional.kafka.consumer;

import br.com.petterson.funcional.kafka.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ConsumerFunction<T> {
    void consume(ConsumerRecord<String, Message<T>> record) throws Exception;
}
