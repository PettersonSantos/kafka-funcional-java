package br.com.petterson.funcional.kafka.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Outro {

    private String outro_name;
    private String teste;
    private BigDecimal dolar;
    private String fabricacao;

    public String getOutro_name() {
        return outro_name;
    }
}
