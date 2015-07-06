import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import domain.Department;

public class Principal4 {

	public static void main(String[] args) 
	{
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		configuration.getProperties()).build();

		SessionFactory session = new Configuration().configure().buildSessionFactory(serviceRegistry);
		
		Department department = new Department();
	    department.setName("Teste 1");

	    Transaction tx = session.beginTransaction();
	    session.save(department);
	    tx.commit();
	}

}
