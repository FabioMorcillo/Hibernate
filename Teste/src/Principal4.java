import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import domain.Department;
import domain.User;

public class Principal4 {

	public static void main(String[] args) 
	{
		Configuration configuration = new Configuration().configure();
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

	    SessionFactory sessionfactory = configuration.buildSessionFactory(serviceRegistry);

	    Session session = sessionfactory.openSession();

		Department department = new Department();
	    department.setName("Teste 1");
	    
	    User user = new User("Fabio");

	    Transaction tx = session.beginTransaction();
	    
	    session.save(department);
	    session.save(user);
	    
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
