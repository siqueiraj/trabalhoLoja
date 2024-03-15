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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.loja.entity.Cliente;
import app.loja.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	@Autowired
	public ClienteService clienteService;

	@GetMapping("/listall")
	public ResponseEntity<List<Cliente>> listAll() {
		try {
			return new ResponseEntity<List<Cliente>>(this.clienteService.listAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findbyId/{idCliente}")
	public ResponseEntity<Cliente> findbyId(@PathVariable long idCliente){
		try {
			Cliente cliente = this.clienteService.findById(idCliente);
			return new ResponseEntity<>(cliente,HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("delete/{idCliente}")
	public ResponseEntity<String> delete(@PathVariable long idCliente){
		try {
			this.clienteService.delete(idCliente);
			return new ResponseEntity<String>("Registro deletado com sucesso", HttpStatus.FOUND);
		}
		catch (Exception e){
			return new ResponseEntity<String>("Erro" +e, HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Cliente cliente){
		try {
			this.clienteService.save(cliente);
			return new ResponseEntity<String>("Registro criado com sucesso",HttpStatus.CREATED);
		}
		catch (Exception e){
			return new ResponseEntity<String>("Erro" +e, HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/update/{idCliente}")
	public ResponseEntity<String> update(@PathVariable long idCliente, @RequestBody Cliente cliente){
		try {
			this.clienteService.update(cliente, idCliente);
			return new ResponseEntity<String> ("Registro alterado com sucesso", HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity<String>("Erro: " +e, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findBynomeCliente")
	public ResponseEntity<List<Cliente>> findBynomeCliente(@RequestParam String nomeCliente){
		try {
			return new ResponseEntity<List<Cliente>>(this.clienteService.findBynomeCliente(nomeCliente), HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findByTelefone")
	public ResponseEntity<List<Cliente>> findByTelefone(@RequestParam String telefone){
		try {
			return new ResponseEntity<List<Cliente>>(this.clienteService.findByTelefone(telefone), HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findByMaiorIdade")
	public ResponseEntity<List<Cliente>> findByIdadeMaior(@RequestParam long idade){
		try {
			return new ResponseEntity<List<Cliente>>(this.clienteService.findByIdadeMaior(idade), HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
