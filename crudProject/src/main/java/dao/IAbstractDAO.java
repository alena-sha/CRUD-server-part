package dao;

import java.util.List;



public interface IAbstractDAO<T> {
	T save(T object);
	void delete(T object);
	List<T> findAll();
	T get(int id);
}
