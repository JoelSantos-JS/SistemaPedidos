package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table
public class Usuario {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private String nome;
	@JoinColumn(name = "email")
	private String email;
	private String senha;
	
	 @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(name = "usuario_grupo", joinColumns = @JoinColumn (name = "usuario_id"),
	            inverseJoinColumns = @JoinColumn(name = "grupo_id")) //LOUCURAAA VER DEPOIS
	private List<Grupo> grupos= new ArrayList<Grupo>();
	
	
	
	public Usuario() {
		
	}



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



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public List<Grupo> getGrupos() {
		return grupos;
	}



	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
