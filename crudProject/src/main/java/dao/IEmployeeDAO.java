package dao;

import model.Employee;

public interface IEmployeeDAO extends IAbstractDAO<Employee>{
	public Employee authenticate(String login,String password);
	public Employee getUserByName(String login);
}
