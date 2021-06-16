package br.com.petterson.funcional.kafka.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Geral {
    private Product products;
    private Outro outros;
    private MessageEnum messageEnum;

    public MessageEnum getMessageEnum() {
        return messageEnum;
    }

    public Product getProducts() {
        return products;
    }

    public Outro getOutros() {
        return outros;
    }
}
