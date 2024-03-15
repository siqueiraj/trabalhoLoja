package app.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.loja.entity.Funcionario;
import app.loja.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	@Autowired
	FuncionarioRepository funcionarioRepository;		
	public String save (Funcionario funcionario) {
		this.funcionarioRepository.save(funcionario);
		return funcionario.getNomeFuncionario()+ " Foi registrado";
	}

	public List <Funcionario> listAll () {
		return this.funcionarioRepository.findAll();

	}

	public Funcionario findById(long id_funcionario) {

		Funcionario funcionario = this.funcionarioRepository.findById(id_funcionario).get();
		return funcionario;

	}

	public String update (Funcionario funcionario, long id_funcionario) {
		funcionario.setIdFuncionario(id_funcionario);
		this.funcionarioRepository.save(funcionario);
		return "O " + funcionario.getNomeFuncionario() + " Foi atualizado";

	}

	public String delete (long id_funcionario) {
		this.funcionarioRepository.deleteById(id_funcionario);
		return "Funcionario deletado";
	}


}