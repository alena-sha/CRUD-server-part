package controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import model.Employee;
import model.Task;
import service.ITaskService;
@RestController
public class TaskController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ITaskService service;
	
	@Autowired
	public TaskController(ITaskService service) {
		this.service = service;
	}

	
	@RequestMapping(value="/employee/{empId}/task", method = RequestMethod.GET ) 
	public List<Task> viewTasksByEmployee(@PathVariable(value = "empId") int id) { 
		 List<Task> list=service.viewTaskForEmployee(id);
		 return list;
	}	 
	
	@RequestMapping(value="employee/{empId}/task/{id}", method = RequestMethod.GET ) 
	public Task getTask(@PathVariable(value = "id") int id) { 
		 return service.get(id);
	}	
	
	@RequestMapping(value="employee/{empId}/task", method = RequestMethod.POST ) 
	@ResponseStatus(HttpStatus.OK)
	public Task updateTask( @RequestBody Task task, @PathVariable(value = "empId") int empId) {
		Employee employee=new Employee();
		employee.setId(empId);
		task.setEmployee(employee);
		task=service.save(task);
		return task;
	}	
	
	
	@RequestMapping(value="employee/{empId}/task/{id}", method = RequestMethod.DELETE ) 
	@ResponseStatus(HttpStatus.OK)
	public void deleteTask( @PathVariable(value = "id") int id,@PathVariable(value = "empId") int empId ) { 
		 Task task=new Task();
		 task.setId(id);
		 service.delete(task);
	}	
}
