package br.com.petterson.funcional.kafka.service;

import br.com.petterson.funcional.kafka.CorrelationId;
import br.com.petterson.funcional.kafka.model.Geral;
import br.com.petterson.funcional.kafka.producer.KafkaDispatcher;

import java.util.concurrent.ExecutionException;

public class ProductService {

    private static final KafkaDispatcher<Geral> geralDispatcher = new KafkaDispatcher();

    public static void enviaMessage(Geral geral) throws ExecutionException, InterruptedException {
        System.out.println("Mensagem Recebida");
        geralDispatcher.send("TOPIC_GERAL_3",  geral.getClass().getName(), new CorrelationId(ProductService.class.getSimpleName()), geral);
    }
}
