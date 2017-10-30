package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Regdetails {

	public void insert(vo.Regdetails r){
		
		SessionFactory sessionFactory=null;

		Configuration configuration = new Configuration().configure(Regdetails.class.getResource("/hibernate.cfg.xml"));
		            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		            serviceRegistryBuilder.applySettings(configuration.getProperties());
		            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session ss = sessionFactory.openSession();
		
		ss.beginTransaction();
		ss.save(r);
		
		
		ss.getTransaction().commit();
		
		ss.close();
	}
}
