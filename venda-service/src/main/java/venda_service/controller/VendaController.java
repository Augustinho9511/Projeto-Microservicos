package venda_service.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import venda_service.model.dto.VendaDTO;
import venda_service.repository.FinanceiroClient;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private FinanceiroClient financeiroClient;

    @PostMapping
    @CircuitBreaker(name = "financeiroService", fallbackMethod = "fallbackFinanceiro")
    public String realizarVenda(@RequestBody VendaDTO venda) {
        System.out.println(">>> VENDA: Realizando venda do produto: " + venda.produto());
        financeiroClient.enviarParaFinanceiro(venda);
        return "Venda realizada e enviada ao financeiro!";
    }
    public String fallbackFinanceiro(VendaDTO venda, Throwable t) {
        return "Venda salva localmente! O financeiro está instável, tentaremos enviar os dados mais tarde.";
    }


}
