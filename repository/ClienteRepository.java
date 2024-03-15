package app.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.loja.entity.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {
		

}
