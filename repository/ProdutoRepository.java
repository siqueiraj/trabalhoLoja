package app.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.loja.entity.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{

}
