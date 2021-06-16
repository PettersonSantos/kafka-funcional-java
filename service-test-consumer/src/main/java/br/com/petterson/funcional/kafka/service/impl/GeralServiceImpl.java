package br.com.petterson.funcional.kafka.service.impl;

import br.com.petterson.funcional.kafka.model.Geral;
import br.com.petterson.funcional.kafka.model.Outro;
import br.com.petterson.funcional.kafka.model.Product;
import br.com.petterson.funcional.kafka.service.GeralService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GeralServiceImpl implements GeralService {
    @Override
    public void printaProduto(Geral geral) {
        Product product = geral.getProducts();
        System.out.println("Nome do Produto: " + product.getNome());

    }

    @Override
    public void pritaOutro(Geral geral) {
        Outro outro = geral.getOutros();
        System.out.println("Nome do Outro: " + outro.getOutro_name());
    }
}
