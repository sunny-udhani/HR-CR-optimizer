package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import vo.AddNationalityVO;

public class AddNationalityDAO {
	
	public void insert(AddNationalityVO v){
		
		SessionFactory sessionFactory=null;

		Configuration configuration = new Configuration().configure(register.class.getResource("/hibernate.cfg.xml"));
		            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		            serviceRegistryBuilder.applySettings(configuration.getProperties());
		            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session ss = sessionFactory.openSession();
		
		ss.beginTransaction();
		ss.save(v);
		
		
		ss.getTransaction().commit();
		
		ss.close();
	}

}
