package app.loja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Produto {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idProduto;
	@NotNull
	private String nomeProduto;
	@NotNull
	private double valorTotal;
	public long getIdProduto() {
		return idProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
