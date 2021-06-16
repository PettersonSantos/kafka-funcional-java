package br.com.petterson.funcional.kafka.endpoint;

import br.com.petterson.funcional.kafka.model.Geral;
import br.com.petterson.funcional.kafka.model.MessageEnum;
import br.com.petterson.funcional.kafka.model.Outro;
import br.com.petterson.funcional.kafka.service.ProductService;
import br.com.petterson.funcional.kafka.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("v1")
public class ProductEndpoint {


    @PostMapping(path = "produtos")
    public ResponseEntity<?> enviaProdutos(@RequestBody Product product) throws ExecutionException, InterruptedException {
        Geral geral = new Geral();
        geral.setProducts(product);
        geral.setMessageEnum(MessageEnum.PRODUCT);
        ProductService.enviaMessage(geral);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "outro")
    public ResponseEntity<?> enviaOutro(@RequestBody Outro outro) throws ExecutionException, InterruptedException {
        Geral geral = new Geral();
        geral.setOutros(outro);
        geral.setMessageEnum(MessageEnum.OUTRO);
        ProductService.enviaMessage(geral);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
