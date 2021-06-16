package br.com.petterson.funcional.kafka.consumer;

import br.com.petterson.funcional.kafka.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ConsumerService<T> {
    void parse(ConsumerRecord<String, Message<T>> record) throws Exception;
    String getTopics();
    String getConsumerGroup();
}
