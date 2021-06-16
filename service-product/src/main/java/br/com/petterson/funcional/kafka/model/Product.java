package br.com.petterson.funcional.kafka.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private String nome;
    private String fabricante;
    private BigDecimal valor;
    private String dataFabricacao;
}
