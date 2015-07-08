package domain;

import javax.persistence.*;

@Entity
@Table( name = "Estados" )
public class Estado 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	public Estado()
	{
		super();
	}
	
	public Estado(String nome)
	{
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
