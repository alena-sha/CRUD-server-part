package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.AbstractDAO;
import dao.EmployeeDAO;
import model.Employee;

@Component
public class EmployeeService extends AbstractService<Employee> implements IEmployeeService {

	private EmployeeDAO employeeDao;

	public EmployeeService() {

	}

	@Autowired
	public EmployeeService(@Qualifier("employeeDao") AbstractDAO<Employee> abstractDao) {
		super(abstractDao);
		this.employeeDao = (EmployeeDAO) abstractDao;
	}

	@Override
	public Employee authenticate(String login, String password) {
		return employeeDao.authenticate(login, password);
	}

}
