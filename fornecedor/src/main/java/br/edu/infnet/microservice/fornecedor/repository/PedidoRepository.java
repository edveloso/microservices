package br.edu.infnet.microservice.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.microservice.fornecedor.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
