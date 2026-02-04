package venda_service.repository;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import venda_service.model.dto.VendaDTO;

@FeignClient(name = "financeiro", url = "${FINANCEIRO_URL:http://localhost:8082}")
public interface FinanceiroClient {

    @PostMapping("/faturas")
    void enviarParaFinanceiro(@RequestBody VendaDTO vendaDTO);
}
