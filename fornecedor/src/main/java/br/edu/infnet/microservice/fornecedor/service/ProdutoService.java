package br.edu.infnet.microservice.fornecedor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.microservice.fornecedor.model.Produto;
import br.edu.infnet.microservice.fornecedor.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private ProdutoRepository produtoRepository;
	
	public List<Produto> getProdutosPorEstado(String estado) {
		return produtoRepository.findByEstado(estado);
	}

	
}
