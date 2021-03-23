package br.edu.infnet.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.microservice.loja.client.FornecedorClient;
import br.edu.infnet.microservice.loja.dto.CompraDTO;
import br.edu.infnet.microservice.loja.dto.InfoFornecedorDTO;
import br.edu.infnet.microservice.loja.dto.InfoPedidoDTO;
import br.edu.infnet.microservice.loja.model.Compra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CompraService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired
	private FornecedorClient fornecedorClient;

	public Compra realizaCompra(CompraDTO compra) {
		
		final String estado = compra.getEndereco().getEstado();
		
		LOG.info("buscando informações do fornecedor de {}", estado);
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(estado);
		
		LOG.info("realizando um pedido");
		InfoPedidoDTO infoPedido = fornecedorClient.realizaPedido(compra.getItens());
		
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(infoPedido.getId());
		compraSalva.setTempoDePreparo(infoPedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(info.getEndereco());
		
		System.out.println(info.getEndereco());
		
		return compraSalva;
	}
	
}
