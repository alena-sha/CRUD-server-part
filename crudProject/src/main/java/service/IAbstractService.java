package service;

import java.util.List;

public interface IAbstractService<T> {
	T save(T object);
	void delete(T object);
	List<T> findAll();
	T get(int id);
}
