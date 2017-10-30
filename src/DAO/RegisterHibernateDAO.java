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

import vo.LeaveEntitlementVO;

public class RegisterHibernateDAO extends GenericHibernateDAO<vo.register, Long> implements RegisterDAO {

	public int insert(vo.register r)
	{
	
		Session ss = LSCD.MyUtility.getSession();
		
		ss.beginTransaction();
		ss.save(r);
		
		
		ss.getTransaction().commit();
		
		ss.close();
		return r.getId();
		
	}
	
	@SuppressWarnings("rawtypes")
	public Boolean search(vo.register v)
	{
		List ls = new ArrayList();
		String s= v.getPassword();
		try
		{
		
		/*String key = "Bar12345Bar12345";
		Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
		 Cipher cipher = Cipher.getInstance("AES");*/
		SessionFactory sessionFactory=null;

		Session ss = LSCD.MyUtility.getSession();
		ss.beginTransaction();
		String hql = "FROM vo.register WHERE username= :user";
		Query query = ss.createQuery(hql);
		query.setParameter("user", v.getUsername() );
		ls = query.list();
	
		Iterator i = ls.iterator();
		
		if(i.hasNext())
		{
			v = (vo.register)i.next();
			if(s.equals(v.getPassword()))
			{
				return true;
			}
			else
				return false;
			
			
		}
		 
		/*cipher.init(Cipher.DECRYPT_MODE, aesKey);
			
          String decrypted = new String(cipher.doFinal(v.getPass()));
          System.out.println(decrypted);
          v.setPass(decrypted.getBytes());*/
		
  		
  		ss.close();
  	return false;
  		
  		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
			}	

	}
}
