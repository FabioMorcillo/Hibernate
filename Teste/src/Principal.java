import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Department;

public class Principal {

	public static void main(String[] args) {
		
	    SessionFactory factory = new Configuration().configure().buildSessionFactory();
	    Session session = factory.openSession();

	    Department department = new Department();
	    department.setName("Teste 1");

	    Transaction tx = session.beginTransaction();
	    session.save(department);
	    tx.commit();

	}

}
