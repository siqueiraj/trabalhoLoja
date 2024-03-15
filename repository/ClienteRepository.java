package app.loja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.loja.entity.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {
	
	public List<Cliente> findBynomeCliente(String nomeCliente);
	public List<Cliente> findByTelefone (String telefone);
	@Query("SELECT c FROM Cliente c WHERE c.idade > :idade")
	public List<Cliente> findByIdadeMaior(long idade);	
}
