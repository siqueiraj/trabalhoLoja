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

import app.loja.entity.Produto;
import app.loja.service.ProdutoService;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {
	@Autowired
	public ProdutoService produtoService;

	@GetMapping("/listall")
	public ResponseEntity<List<Produto>> listAll() {
		try {
			return new ResponseEntity<List<Produto>>(this.produtoService.listAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findbyId/{idProduto}")
	public ResponseEntity<Produto> findbyId(@PathVariable long idProduto){
		try {
			Produto produto = this.produtoService.findById(idProduto);
			return new ResponseEntity<>(produto,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("delete/{idProduto}")
	public ResponseEntity<String> delete(@PathVariable long idProduto){
		try {
			this.produtoService.delete(idProduto);
			return new ResponseEntity<String>("Registro deletado com sucesso", HttpStatus.FOUND);
		}
		catch (Exception e){
			return new ResponseEntity<String>("Erro" +e, HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Produto produto){
		try {
			this.produtoService.save(produto);
			return new ResponseEntity<String>("Registro criado com sucesso",HttpStatus.CREATED);
		}
		catch (Exception e){
			return new ResponseEntity<String>("Erro" +e, HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/update/{idProduto}")
	public ResponseEntity<String> update(@PathVariable long idProduto, @RequestBody Produto produto){
		try {
			this.produtoService.update(produto, idProduto);
			return new ResponseEntity<String> ("Registro alterado com sucesso", HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity<String>("Erro: " +e, HttpStatus.BAD_REQUEST);
		}
		
	}

}
