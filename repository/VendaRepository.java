package app.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.loja.entity.Venda;

public interface VendaRepository extends JpaRepository <Venda, Long> {

}
