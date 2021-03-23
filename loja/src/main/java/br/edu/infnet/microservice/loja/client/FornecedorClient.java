package br.edu.infnet.microservice.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.microservice.loja.dto.InfoFornecedorDTO;
import br.edu.infnet.microservice.loja.dto.InfoPedidoDTO;
import br.edu.infnet.microservice.loja.dto.ItemDaCompraDTO;

@FeignClient("fornecedor")
public interface FornecedorClient {

	@RequestMapping("/info/{estado}")
	InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

	@RequestMapping(method=RequestMethod.POST, value="/pedido")
	InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens);
}
