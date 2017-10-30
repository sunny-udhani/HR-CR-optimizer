package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;





import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class register {

	public int insert(vo.register r)
	{
		SessionFactory sessionFactory=null;

		Configuration configuration = new Configuration().configure(register.class.getResource("/hibernate.cfg.xml"));
		            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		            serviceRegistryBuilder.applySettings(configuration.getProperties());
		            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session ss = sessionFactory.openSession();
		
		ss.beginTransaction();
		ss.save(r);
		
		
		ss.getTransaction().commit();
		
		ss.close();
		return r.getId();
		
	}
	
}
