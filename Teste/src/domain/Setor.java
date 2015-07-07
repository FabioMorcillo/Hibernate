package domain;

import javax.persistence.*;

@Entity
@Table( name = "Setores" )
public class Setor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	public Setor()
	{
		super();
	}
	
	public Setor(String nome)
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
	
	
}
