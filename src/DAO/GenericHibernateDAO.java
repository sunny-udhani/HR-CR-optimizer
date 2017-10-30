package DAO;

import java.io.Serializable;
import java.util.List;
import java.lang.reflect.ParameterizedType;


import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

import LSCD.MyUtility;

public abstract class GenericHibernateDAO<T, ID extends Serializable>  
implements GenericDAO<T, ID> {  

private Class<T> persistentClass;  
private Session session;  
private Transaction tx;


/*@SuppressWarnings("unchecked")
public GenericHibernateDAO() {  
this.persistentClass = (Class<T>) ((ParameterizedType) getClass()  
                        .getGenericSuperclass()).getActualTypeArguments()[0];  
}  */

public Transaction getTx() {
	tx = getSession().beginTransaction();
	return tx;
}

public void setTx(Transaction tx) {
	this.tx = tx;
}

@SuppressWarnings("unchecked")
public GenericHibernateDAO() {
	this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];
}

public GenericHibernateDAO(final Class<T> persistentClass) {
	super();
	this.persistentClass = persistentClass;
}

@SuppressWarnings("unchecked")  
public void setSession(Session s) {  
this.session = s;  
}  

public Session getSession() {
	//MyUtility.getCurrentSession()
if (session == null)  
    throw new IllegalStateException("Session has not been set on DAO before usage");  
return session;  
}  

public Class<T> getPersistentClass() {  
return persistentClass;  
}  

@SuppressWarnings("unchecked")
public List<T> findByQuery(final String queryName,  Object... params)
{
	Query q = getSession().createQuery(queryName);
	
	for (int i = 0; i < params.length; i++) {
		q.setParameter(i , params[i]);
	}

	final List<T> result = (List<T>) q.list();
	
	return result;
}

@SuppressWarnings("unchecked")  
public T findById(ID id, boolean lock) {  
T entity;  
if (lock)  
    entity = (T) getSession().load(getPersistentClass(), id, LockMode.UPGRADE);  
else  
    entity = (T) getSession().load(getPersistentClass(), id);  

return entity;  
}  

@SuppressWarnings("unchecked")  
@Override
public List<T> findAll(T instance) {
	String q= "From vo."+getPersistentClass().getSimpleName();
	Query qu = getSession().createQuery(q);
	List ls = qu.list();
	return ls;
}

@SuppressWarnings("unchecked")  
public List<T> findByExample(T exampleInstance, String[] excludeProperty) {  
Criteria crit = getSession().createCriteria(getPersistentClass());  
Example example =  Example.create(exampleInstance);  
for (String exclude : excludeProperty) {  
    example.excludeProperty(exclude);  
}  
crit.add(example);  
return crit.list();  
}  

@SuppressWarnings("unchecked")  
public T makePersistent(T entity) { 

getSession().save(entity);
return entity;  
}  

public void makeTransient(T entity) {  
getSession().delete(entity);  
}  

public void flush() {  
getSession().flush();  
}  

public void clear() {  
getSession().clear();  
}  

public void update(T domain) {

getSession().merge(domain);

}

/** 
* Use this inside subclasses as a convenience method. 
*/  
@SuppressWarnings("unchecked")  
protected List<T> findByCriteria(Criterion... criterion) {  
Criteria crit = getSession().createCriteria(getPersistentClass());  
for (Criterion c : criterion) {  
    crit.add(c);  
}  
return crit.list();  
}  

}  
