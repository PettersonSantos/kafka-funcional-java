package br.com.petterson.funcional.kafka.model;


import java.util.List;

public class Geral {
    private Product products;
    private Outro outros;
    private MessageEnum messageEnum;


    public void setMessageEnum(MessageEnum messageEnum) {
        this.messageEnum = messageEnum;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public void setOutros(Outro outros) {
        this.outros = outros;
    }
}
