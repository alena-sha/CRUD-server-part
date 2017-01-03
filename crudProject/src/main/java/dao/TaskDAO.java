package dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import model.Task;

@Repository

@Qualifier("taskDao")
public class TaskDAO extends AbstractDAO<Task> implements ITaskDAO {

	public TaskDAO(){
		
	}
	@Override
	public List<Task> viewTaskForEmployee(int id) {
		System.out.println("!!!!!!taskd");
		Criteria crit = getSessionFactory().getCurrentSession().createCriteria(Task.class);
		crit.add(Restrictions.eq("employee.id", (Integer)id));
		return crit.list();
	}

}
