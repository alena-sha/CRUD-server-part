package service;

import java.util.List;

import model.Employee;

public interface IEmployeeService extends IAbstractService<Employee>{
	
	public Employee authenticate(String login,String password);
	
}
