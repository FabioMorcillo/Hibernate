package domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import javax.persistence.*;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

@Entity
@Table( name = "Setores" )
public class Setor // implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "setor_id")
	private Set<Usuario> usuarios;
	
	public Setor()
	{
		super();
	}
	
	public long getId() {
		return id;
	}	
	
	public void setId(long id) {
		this.id = id;
	}

	public Setor(String nome)
	{
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	
}

/*
 * https://www.ibm.com/developerworks/community/blogs/fd26864d-cb41-49cf-b719-d89c6b072893/entry/como_criar_relacionamento_onetomany_com_hibernate?lang=en
 */
