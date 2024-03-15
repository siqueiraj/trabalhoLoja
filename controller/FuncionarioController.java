package app.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.loja.entity.Funcionario;
import app.loja.service.FuncionarioService;

@RestController
@RequestMapping("api/funcionario")
public class FuncionarioController {
	@Autowired
	public FuncionarioService funcionarioService;

	@GetMapping("/listall")
	public ResponseEntity<List<Funcionario>> listAll() {
		try {
			return new ResponseEntity<List<Funcionario>>(this.funcionarioService.listAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findbyId/{idFuncionario}")
	public ResponseEntity<Funcionario> findbyId(@PathVariable long idFuncionario){
		try {
			Funcionario funcionario = this.funcionarioService.findById(idFuncionario);
			return new ResponseEntity<>(funcionario,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/delete/{idFuncionario}")
	public ResponseEntity<String> delete(@PathVariable long idFuncionario){
		try {
			this.funcionarioService.delete(idFuncionario);
			return new ResponseEntity<String>("Registro deletado com sucesso", HttpStatus.FOUND);
		}
		catch (Exception e){
			return new ResponseEntity<String>("Erro" +e, HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Funcionario funcionario){
		try {
			this.funcionarioService.save(funcionario);
			return new ResponseEntity<String>("Registro criado com sucesso",HttpStatus.CREATED);
		}
		catch (Exception e){
			return new ResponseEntity<String>("Erro" +e, HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/update/{idFuncionario}")
	public ResponseEntity<String> update(@PathVariable long idFuncionario, @RequestBody Funcionario funcionario){
		try {
			this.funcionarioService.update(funcionario, idFuncionario);
			return new ResponseEntity<String> ("Registro alterado com sucesso", HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity<String>("Erro: " +e, HttpStatus.BAD_REQUEST);
		}
		
	}
}
