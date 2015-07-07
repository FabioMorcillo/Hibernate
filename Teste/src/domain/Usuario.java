package domain;

import javax.persistence.*;

@Entity
@Table ( name="Usuarios" )
public class Usuario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
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

	public void setName(String nome) {
		this.nome = nome;
	}
	
	
	
}
