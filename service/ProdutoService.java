package app.loja.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.loja.entity.Produto;
import app.loja.repository.ProdutoRepository;
@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;		
	public String save (Produto produto) {
		this.produtoRepository.save(produto);
		return produto.getNomeProduto()+ " Foi registrado";
	}

	public List <Produto> listAll () {
		return this.produtoRepository.findAll();
	}

	public Produto findById(long idProduto) {

		Produto produto = this.produtoRepository.findById(idProduto).get();
		return produto;
	}

	public String update (Produto produto, long idProduto) {
		produto.setIdProduto(idProduto);
		this.produtoRepository.save(produto);
		return "O " + produto.getNomeProduto() + " Foi atualizado";
	}

	public String delete (long id_produto) {
		this.produtoRepository.deleteById(id_produto);
		return "Funcionario deletado";
	}

}
