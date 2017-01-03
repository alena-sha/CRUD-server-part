package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractDAO<T> implements IAbstractDAO<T> {

	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> type;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public AbstractDAO() {
		this.type = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), IAbstractDAO.class);
		
	}

	@Transactional
	@Override
	public T save(T object) {

		sessionFactory.getCurrentSession().saveOrUpdate(object);
		return object;
	}

	@Transactional
	@Override
	public void delete(T object) {
		sessionFactory.getCurrentSession().delete(object);

	}

	@Transactional
	@Override
	public List<T> findAll() {
		List<T> list = sessionFactory.getCurrentSession().createCriteria(type).list();
		return list;

	}

	@Transactional
	@Override
	public T get(int id) {
		T emp = (T) sessionFactory.getCurrentSession().get(type, new Integer(id));
		return emp;
	}

}
