package service;

import java.util.List;

import model.Task;

public interface ITaskService extends IAbstractService<Task> {
	public List<Task> viewTaskForEmployee(int id);

}
