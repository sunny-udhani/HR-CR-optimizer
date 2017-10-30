package DAO;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
	 
		  
	    T findById(ID id, boolean lock);  
	  
	    List<T> findAll(T t);
	    
	    List<T> findByQuery(
	            final String queryName,
	            Object... params
	        );
	  
	    List<T> findByExample(T entity, String[] excludeProperty);  
	  
	    T makePersistent(T entity);  
	  
	    void makeTransient(T entity);  
	    
	    void update(T entity); 
}
