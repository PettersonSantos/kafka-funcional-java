package br.com.petterson.funcional.kafka.service;

import br.com.petterson.funcional.kafka.Message;
import br.com.petterson.funcional.kafka.consumer.GsonDeserealizer;
import br.com.petterson.funcional.kafka.enums.GeralEnum;
import br.com.petterson.funcional.kafka.model.Geral;
import br.com.petterson.funcional.kafka.service.impl.GeralServiceImpl;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;


public abstract class ConsumerGeralService {

    private static final GeralService service = new GeralServiceImpl();

    public static void main(String[] args) {

        var consumer = new KafkaConsumer<String, Message<Geral>>(properties());

        consumer.subscribe(Collections.singletonList("TOPIC_GERAL_3"));

        while (true) {
            var records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, Message<Geral>> registro : records) {

                var message = registro.value();

                var product = message.getPayload();

                GeralEnum geralEnum = GeralEnum.valueOf(product.getMessageEnum().toString());

                geralEnum.handler.accept(service, product);

            }
        }

    }



    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, GsonDeserealizer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, ConsumerGeralService.class.getName());
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        return properties;
    }

}
