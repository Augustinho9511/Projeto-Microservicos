package financeiro_service.controller;

import financeiro_service.model.dto.VendaDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faturas")
public class FinanceiroController {

    @PostMapping
    public void criarFatura(@RequestBody VendaDTO venda) {
        System.out.println(">>> FINANCEIRO: Gerando fatura para o produto: " + venda.produto());
        System.out.println(">>> Valor: R$ " + venda.valor());

    }
}