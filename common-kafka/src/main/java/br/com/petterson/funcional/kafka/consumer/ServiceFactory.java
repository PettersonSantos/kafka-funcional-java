package br.com.petterson.funcional.kafka.consumer;

public interface ServiceFactory<T> {
    ConsumerService<T> create() throws Exception;
}
