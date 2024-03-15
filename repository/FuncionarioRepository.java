package app.loja.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import app.loja.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {
	
}
