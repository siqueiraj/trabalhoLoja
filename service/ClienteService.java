package app.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.loja.entity.Cliente;
import app.loja.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	public String save (Cliente cliente) {
		this.clienteRepository.save(cliente);
		return cliente.getNomeCliente() + " Foi registrado";
	}

	public List <Cliente> listAll () {
		return this.clienteRepository.findAll();
	}
	
	public Cliente findById(long id_cliente) {
		
		Cliente cliente = this.clienteRepository.findById(id_cliente).get();
		return cliente;

	}

	public String update (Cliente cliente, long id_cliente) {
		cliente.setIdCliente(id_cliente);
		this.clienteRepository.save(cliente);
		return "O " + cliente.getNomeCliente() + " Foi atualizado";

	}

	public String delete (long id_cliente) {
		this.clienteRepository.deleteById(id_cliente);
		return "Cliente deletado!";
	}

}
