package main;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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

	    Transaction tx = session.beginTransaction();
	    
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