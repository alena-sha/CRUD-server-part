package dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import model.Employee;

@Repository

@Qualifier("employeeDao")
public class EmployeeDAO extends AbstractDAO<Employee> implements IEmployeeDAO {

	public EmployeeDAO() {
		
	}

	public Employee authenticate(String login, String password) {
		Criteria crit = getSessionFactory().getCurrentSession().createCriteria(Employee.class);
		crit.add(Restrictions.eq("login", login));
		crit.add(Restrictions.eq("password", password));

		return (Employee) crit.uniqueResult();
	}

	@Transactional
	public Employee getUserByName(String login) {
		Criteria crit = getSessionFactory().getCurrentSession().createCriteria(Employee.class);
		crit.add(Restrictions.eq("login", login));

		return (Employee) crit.uniqueResult();
	}

}
