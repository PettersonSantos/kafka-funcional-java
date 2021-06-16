package br.com.petterson.funcional.kafka.enums;

import br.com.petterson.funcional.kafka.model.Geral;
import br.com.petterson.funcional.kafka.service.GeralService;

import java.util.function.BiConsumer;

public enum GeralEnum {
    PRODUCT(GeralService::printaProduto),
    OUTRO(GeralService::pritaOutro);

    public BiConsumer<GeralService, Geral> handler;

    GeralEnum(BiConsumer<GeralService, Geral> handler) {
        this.handler = handler;
    }
}
