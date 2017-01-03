package dao;

import java.util.List;

import model.Task;

public interface ITaskDAO {
public List<Task> viewTaskForEmployee(int id);
}
