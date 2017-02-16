package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import dao.AbstractDAO;
import dao.IAbstractDAO;
import model.Employee;

@EnableTransactionManagement
public abstract class AbstractService<T> implements IAbstractService<T> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private AbstractDAO<T> abstractDao;

	@Autowired
	public AbstractService(AbstractDAO<T> abstractDao) {
	
		this.abstractDao = abstractDao;
	}

	public AbstractService() {
	}

	@Transactional
	@Override
	public T save(T object) {
		return abstractDao.save(object);
	}

	@Transactional
	public void delete(T object) {
		abstractDao.delete(object);
	}

	@Override
	public List<T> findAll() {
		return abstractDao.findAll();
	}

	@Override
	public T get(int id) {
		return abstractDao.get(id);
	}

}
