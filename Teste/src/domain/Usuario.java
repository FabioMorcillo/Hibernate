package domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table ( name="Usuarios" )
public class Usuario // implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	
	private long id;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@ManyToOne(cascade = CascadeType.ALL)	
	private Setor setor;	
	
	public Usuario()
	{
		super();
	}
	
	public Usuario(String nome)
	{
		this.nome = nome;
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
	
	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	
	
	
	
}
