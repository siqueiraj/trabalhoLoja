package app.loja.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Funcionario {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idFuncionario;
	@NotNull
	private String nomeFuncionario;
	@NotNull
	private long idadeFuncionario;
	@NotNull
	private String matricula;

	@OneToMany(mappedBy = "funcionario")
	private List<Venda> venda;

	public long getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	public long getIdadeFuncionario() {
		return idadeFuncionario;
	}
	public void setIdadeFuncionario(long idadeFuncionario) {
		this.idadeFuncionario = idadeFuncionario;
	}
	public List<Venda> getVenda() {
		return venda;
	}
	public void setVenda(List<Venda> venda) {
		this.venda = venda;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
