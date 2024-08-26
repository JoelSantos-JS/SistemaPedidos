package model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable = false , length = 100)
	private String nome;
	@Column(nullable = false , length = 100)
	private String email;
	@Column(name ="doc_rf", nullable =  false , length = 14)
	private String docuemntoReceitaFederal;
	
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipo;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL) //Um Cliente possui vários endereços 
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDocuemntoReceitaFederal() {
		return docuemntoReceitaFederal;
	}
	public void setDocuemntoReceitaFederal(String docuemntoReceitaFederal) {
		this.docuemntoReceitaFederal = docuemntoReceitaFederal;
	}
	public TipoPessoa getTipo() {
		return tipo;
	}
	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}
	
	
}
