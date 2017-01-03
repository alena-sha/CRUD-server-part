package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dao.AbstractDAO;
import dao.TaskDAO;
import model.Task;

@Component
public class TaskService extends AbstractService<Task> implements ITaskService {
	private TaskDAO taskDao;

	public TaskService() {

	}

	@Autowired
	public TaskService(@Qualifier("taskDao") AbstractDAO<Task> abstractDao) {
		super(abstractDao);
		this.taskDao = (TaskDAO) abstractDao;
	}
	@Transactional
	@Override
	public List<Task> viewTaskForEmployee(int id) {
		return taskDao.viewTaskForEmployee(id);
	}

}
