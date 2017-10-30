package LSCD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class MyUtility {

	public static Session getSession(){
		Session ss = null;
		try{
		SessionFactory sessionFactory=null;

		Configuration configuration = new Configuration().configure(MyUtility.class.getResource("/hibernate.cfg.xml"));
		            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		            serviceRegistryBuilder.applySettings(configuration.getProperties());
		            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		ss = sessionFactory.openSession();
		}
		catch(Exception ex){ex.printStackTrace();}
		return ss;
	}
	
	public static Session getCurrentSession()
	{
		SessionFactory sessionFactory=null;

		Configuration configuration = new Configuration().configure(MyUtility.class.getResource("/hibernate.cfg.xml"));
		            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		            serviceRegistryBuilder.applySettings(configuration.getProperties());
		            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session ss = sessionFactory.getCurrentSession();
		return ss;
	}
	
}
