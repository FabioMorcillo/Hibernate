package main;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import domain.Estado;
import domain.Setor;
import domain.Usuario;

public class Principal {

	public static void main(String[] args) 
	{
		Configuration configuration = new Configuration().configure();
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

	    SessionFactory sessionfactory = configuration.buildSessionFactory(serviceRegistry);

	    Session session = sessionfactory.openSession();

		Setor setor1 = new Setor("Setor 1");
		Setor setor2 = new Setor("Setor 2");
		Setor setor3 = new Setor("Setor 3");
		Setor setor4 = new Setor("Setor 4");
		Setor setor5 = new Setor("Setor 5");
    
	    Usuario usuario1 = new Usuario("Fabio");
	    Usuario usuario2 = new Usuario("Tassia");
	    Usuario usuario3 = new Usuario("Raphaella");
	    Usuario usuario4 = new Usuario("Michelle");
	    Usuario usuario5 = new Usuario("Joao");

	    Estado estado1 = new Estado("Estado 1");
	    Estado estado2 = new Estado("Estado 2");
	    Estado estado3 = new Estado("Estado 3");
	    Estado estado4 = new Estado("Estado 4");
	    Estado estado5 = new Estado("Estado 5");
	    
	    usuario1.setSetor(setor5);
	    usuario2.setSetor(setor5);
	    usuario3.setSetor(setor5);
	    usuario4.setSetor(setor5);
	    usuario5.setSetor(setor5);
	    
	    Set<Estado> estados = new HashSet<Estado>();
	    
	    estados.add(estado1);
	    estados.add(estado2);
	    estados.add(estado3);
	    estados.add(estado4);
	    estados.add(estado5);
	    
	    usuario1.setEstados( estados );
	    
	    /*
	    Transaction tx = session.beginTransaction();
	    
	    session.save(estado1);
	    session.save(estado2);
	    session.save(estado3);
	    session.save(estado4);
	    session.save(estado5);
	    
	    session.save(setor1);
	    session.save(setor2);
	    session.save(setor3);
	    session.save(setor4);
	    session.save(setor5);
	    
	    session.save(usuario1);
	    session.save(usuario2);
	    session.save(usuario3);
	    session.save(usuario4);
	    session.save(usuario5);
	    
	    tx.commit();
	    
	    */

	    /*
	     * Primeira solução para remover os registros duplicados na root entity
	     * 
	    List<Setor> listaSetor = (List<Setor>) session.createCriteria(Setor.class)
	    						.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
	    						.list();
	    */

	    List<Setor> listaSetor = (List<Setor>) session.createCriteria(Setor.class)
				.list();

	    Set<Setor> setSetor = new HashSet<Setor>(listaSetor);
	    
	    Set<Usuario> listaUsuario;
	    Set<Estado> listaEstado;
	    
	    for (Setor setor : setSetor)
	    {
	    	System.out.println("Setor -> " + setor.getNome());

	    	listaUsuario = setor.getUsuarios();
	    	
	    	if ( listaUsuario != null )
	    	{
	    		for ( Usuario usuario : listaUsuario )
	    		{
	    			System.out.println("\t" + usuario.getNome());
	    			
	    			listaEstado = usuario.getEstados();
	    			
	    			for ( Estado estado : listaEstado )
		    		{
		    			System.out.println("\t\t" + estado.getNome());
		    		}
	    		}
	    	}
	    	else
	    	{
	    		System.out.println("\tSem Usuarios...");
	    	}
	    }
	    
	    sessionfactory.close();
	}

}


/*
 * SITES INTERESSANTES 
 *
  
  http://www.beingjavaguys.com/2014/05/spring4-hibernate4-integration.html
  http://websystique.com/springmvc/spring-4-mvc-and-hibernate4-integration-example-using-annotations/
  http://www.guj.com.br/8582-hibernate--postgresql--demora-em-sessionbegintransaction
  http://javafree.uol.com.br/topic-888893-Persistencia-com-Hibernate.html
  
*/