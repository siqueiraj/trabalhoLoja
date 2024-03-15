package app.loja.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVenda;
	private String enderecoVenda;
	@NotNull
	private double valorVenda;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JsonIgnoreProperties("venda")
	private Funcionario funcionario;
	
	@ManyToOne (cascade= CascadeType.ALL)
	@JsonIgnoreProperties("venda")
	private Cliente cliente;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable (name = "vendaProduto")
	private List <Produto> produto;
	
	public long getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(long id_venda) {
		this.idVenda = id_venda;
	}
	public String getEnderecoVenda() {
		return enderecoVenda;
	}
	public void setEnderecoVenda(String endereco_venda) {
		this.enderecoVenda = endereco_venda;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valor_venda) {
		this.valorVenda = valor_venda;
	}
	
}
